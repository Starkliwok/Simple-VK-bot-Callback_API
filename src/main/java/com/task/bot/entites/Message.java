package com.task.bot.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.task.bot.constraints.RequestConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    @JsonProperty(RequestConstants.MESSAGE_DATE)
    private long date;

    @JsonProperty(RequestConstants.MESSAGE_FROM_ID)
    private long fromId;

    @JsonProperty(RequestConstants.MESSAGE_ID)
    private int id;

    @JsonProperty(RequestConstants.MESSAGE_OUT)
    private int out;

    @JsonProperty(RequestConstants.MESSAGE_VERSION)
    private int version;

    @JsonProperty(RequestConstants.MESSAGE_ATTACHMENTS)
    private String[] attachments;

    @JsonProperty(RequestConstants.MESSAGE_CONVERSATION_MESSAGE_ID)
    private int conversationMessageId;

    @JsonProperty(RequestConstants.MESSAGE_FWD_MESSAGES)
    private String[] fwdMessages;

    @JsonProperty(RequestConstants.MESSAGE_IMPORTANT)
    private boolean important;

    @JsonProperty(RequestConstants.MESSAGE_IS_HIDDEN)
    private boolean hidden;

    @JsonProperty(RequestConstants.MESSAGE_PEER_ID)
    private long peerId;

    @JsonProperty(RequestConstants.MESSAGE_RANDOM_ID)
    private int randomId;

    @JsonProperty(RequestConstants.MESSAGE_TEXT)
    private String text;

    @JsonProperty(RequestConstants.MESSAGE_IS_MENTIONED_USER)
    private boolean mentionedUser;
}
