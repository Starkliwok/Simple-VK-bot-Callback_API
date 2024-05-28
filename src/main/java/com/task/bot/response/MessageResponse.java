package com.task.bot.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.bot.constraints.VkApiConstants;
import com.task.bot.entites.Event;
import com.task.bot.enums.ApiMethod;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.List;

@Getter
@RequiredArgsConstructor
public abstract class MessageResponse {

    private final Event event;

    private final String accessToken;

    protected abstract List<NameValuePair> getQueryParameters();

    @SneakyThrows
    public void processResponse(ApiMethod method) {
        try (CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD).build()).build();) {
            HttpGet httpGet = new HttpGet(VkApiConstants.ENDPOINT + method.getMethodPath());
            httpGet.setURI(new URIBuilder(httpGet.getURI()).addParameters(getQueryParameters()).build());

            try (CloseableHttpResponse response = client.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                String responseString = EntityUtils.toString(entity, "UTF-8");
                JsonNode jsonNode = new ObjectMapper().readTree(responseString);
                if (!jsonNode.path("error").isEmpty()) {
                    System.out.println("error: '" + jsonNode.path("error_msg").asText() +
                            "' with code [" + jsonNode.path("error_code").asText() + "]\n" +
                            "request parameters:\n" +
                            jsonNode.path("request_params").toPrettyString());
                }
            }
        }
    }
}
