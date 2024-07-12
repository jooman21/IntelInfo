package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class IntelInfoAcceptedEvent extends IntelInfoAcceptEvent<IntelInfo>{
    public  IntelInfoAcceptedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
