package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class MessageSentEvent extends sendMessageEvent<IntelInfo> {

    public MessageSentEvent( IntelInfo intelInfo, String declineReason, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
