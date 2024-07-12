package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class ReasonRegisteredEvent extends RegisterReasonEvent<IntelInfo>{
    public ReasonRegisteredEvent(IntelInfo intelInfo, String declineReason, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }


}
