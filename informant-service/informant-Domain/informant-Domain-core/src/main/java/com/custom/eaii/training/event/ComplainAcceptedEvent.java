package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class ComplainAcceptedEvent  extends ComplaintAcceptEvent<IntelInfo>{
    public ComplainAcceptedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
