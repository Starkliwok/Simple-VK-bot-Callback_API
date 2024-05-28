package com.task.bot.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.task.bot.constraints.RequestConstants;
import com.task.bot.enums.ApiCallback;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    @JsonProperty(RequestConstants.EVENT_GROUP_ID)
    private Long groupId;

    @JsonProperty(RequestConstants.EVENT_TYPE)
    private ApiCallback type;

    @JsonProperty(RequestConstants.EVENT_ID)
    private String eventId;

    @JsonProperty(RequestConstants.EVENT_V)
    private String v;

    @JsonProperty(RequestConstants.EVENT_OBJECT)
    private EventObject eventObject;

    @JsonProperty(RequestConstants.EVENT_SECRET)
    private String secretKey;

    @Override
    public String toString() {
        switch(type) {
            case MESSAGE_NEW -> {
                return "type: '" + type.name() + "', body: '" +
                        eventObject.getMessage().getText() + "', from user_id: " +
                        eventObject.getMessage().getFromId();
            }
            case MESSAGE_REPLY -> {
                return "type: '" + type.name() + "', body: '" +
                        eventObject.getMessage().getText() + "', to user_id: " +
                        eventObject.getMessage().getFromId();
            }
            default -> {
                return "type: '" + type.name();
            }
        }
    }
}
