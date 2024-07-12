package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class SecondDeadLineCheckedEvent extends CheckSecondDeadLineEvent<IntelInfo>{
    public SecondDeadLineCheckedEvent(IntelInfo intelInfo, String createdAt) {
        super(intelInfo, ZonedDateTime.parse(createdAt));
    }
}
