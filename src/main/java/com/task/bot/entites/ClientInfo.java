package com.task.bot.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.task.bot.constraints.RequestConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientInfo {

    @JsonProperty(RequestConstants.CLIENT_INFO_BUTTON_ACTIONS)
    private String[] buttonActions;

    @JsonProperty(RequestConstants.CLIENT_INFO_KEYBOARD)
    private boolean keyboard;

    @JsonProperty(RequestConstants.CLIENT_INFO_INLINE_KEYBOARD)
    private boolean inlineKeyboard;

    @JsonProperty(RequestConstants.CLIENT_INFO_CAROUSEL)
    private boolean carousel;

    @JsonProperty(RequestConstants.CLIENT_INFO_LANG_ID)
    private int langId;
}
