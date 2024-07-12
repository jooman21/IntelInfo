package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class ContactUpdatedEvent extends UpdateContactEvent<IntelInfo>{
    public ContactUpdatedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
