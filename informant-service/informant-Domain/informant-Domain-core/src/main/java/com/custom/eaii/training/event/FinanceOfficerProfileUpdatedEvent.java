package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class FinanceOfficerProfileUpdatedEvent extends UpdateFinanceOfficerProfileEvent<IntelInfo>{
    public FinanceOfficerProfileUpdatedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
