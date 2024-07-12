package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class UnsuccessfulOperationResultMessageSentEvent extends SendUnsuccessfulOperationResultMessageEvent<IntelInfo>{
    public UnsuccessfulOperationResultMessageSentEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
