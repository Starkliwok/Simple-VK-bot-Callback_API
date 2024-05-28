package com.task.bot.enums;

import com.task.bot.constraints.VkApiConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ApiMethod {
    MESSAGE_SEND(VkApiConstants.METHOD_MESSAGE_SEND);

    private final String methodPath;
}
