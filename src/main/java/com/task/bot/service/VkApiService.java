package com.task.bot.service;

import com.task.bot.AppConfig;
import com.task.bot.entites.Event;
import com.task.bot.enums.ApiCallback;
import com.task.bot.enums.ApiMethod;
import com.task.bot.response.DefaultMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VkApiService {

    private final AppConfig config;

    public String doResponse(Event event) {
        if (!event.getSecretKey().equals(config.getSecretKey())) {
            return "error";
        } else if (event.getType() == ApiCallback.CONFIRMATION) {
            return config.getConfirmationToken();
        } else if (event.getType() == ApiCallback.MESSAGE_NEW) {
            new DefaultMessageResponse(event, config.accessToken).processResponse(ApiMethod.MESSAGE_SEND);
        }
        return "ok";
    }
}