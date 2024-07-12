package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class IntelInfoRegisteredEvent extends IntelInfoRegisterEvent<IntelInfo> {

    public IntelInfoRegisteredEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
