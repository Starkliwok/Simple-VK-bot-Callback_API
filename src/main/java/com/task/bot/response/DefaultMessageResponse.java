package com.task.bot.response;

import com.task.bot.constraints.VkApiConstants;
import com.task.bot.entites.Event;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class DefaultMessageResponse extends MessageResponse {
    public DefaultMessageResponse(Event event, String accessToken) {
        super(event, accessToken);
    }

    @Override
    protected List<NameValuePair> getQueryParameters() {
        List<NameValuePair> nameValuePairs = new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("message", "Вы сказали: " + super.getEvent()
                .getEventObject().getMessage().getText()));
        nameValuePairs.add(new BasicNameValuePair("peer_id", String.valueOf(super.getEvent()
                .getEventObject().getMessage().getPeerId())));
        nameValuePairs.add(new BasicNameValuePair("access_token", super.getAccessToken()));
        nameValuePairs.add(new BasicNameValuePair("v", VkApiConstants.VERSION));
        nameValuePairs.add(new BasicNameValuePair("random_id", String.valueOf(new SecureRandom().nextInt())));

        return nameValuePairs;
    }
}
