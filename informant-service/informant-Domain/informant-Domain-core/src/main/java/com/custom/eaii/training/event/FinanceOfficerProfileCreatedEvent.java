package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class FinanceOfficerProfileCreatedEvent extends CreateFinanceOfficerEvent<IntelInfo>{
    public FinanceOfficerProfileCreatedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
