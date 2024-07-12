package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class FinanceOfficerProfileRemovedEvent  extends RemoveFinanceOfficerEvent<IntelInfo>{
    public FinanceOfficerProfileRemovedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
