package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class DeadLineCheckedEvent extends CheckDeadLineEvent<IntelInfo>{
    public DeadLineCheckedEvent(IntelInfo intelInfo, String createdAt) {
        super(intelInfo, ZonedDateTime.parse(createdAt));
    }
}
