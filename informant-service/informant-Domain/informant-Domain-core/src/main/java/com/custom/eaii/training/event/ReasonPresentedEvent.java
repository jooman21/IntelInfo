package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class ReasonPresentedEvent extends PresentReasonEvent<IntelInfo>{
    public ReasonPresentedEvent(IntelInfo intelInfo, String createdAt) {
        super(intelInfo, ZonedDateTime.parse(createdAt));
    }
}
