package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class IntelInfoDeclinedEvent extends IntelInfoDeclineEvent<IntelInfo>{
    public IntelInfoDeclinedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
