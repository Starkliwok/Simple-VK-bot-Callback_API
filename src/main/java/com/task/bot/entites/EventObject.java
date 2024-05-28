package com.task.bot.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.task.bot.constraints.RequestConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventObject {

    @JsonProperty(RequestConstants.EVENT_OBJECT_MESSAGE)
    private Message message;

    @JsonProperty(RequestConstants.EVENT_OBJECT_CLIENT_INFO)
    private ClientInfo client_info;
}
