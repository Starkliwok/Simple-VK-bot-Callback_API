package com.task.bot.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.task.bot.constraints.CallbackApiConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ApiCallback {
    MESSAGE_REPLY(CallbackApiConstants.EVENT_MESSAGE_REPLAY),
    CONFIRMATION(CallbackApiConstants.EVENT_CONFIRMATION),
    MESSAGE_NEW(CallbackApiConstants.EVENT_MESSAGE_NEW);

    @JsonValue
    private final String type;
}
