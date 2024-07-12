package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class EmployeeProfileUpdatedEvent  extends UpdateEmployeeProfileEvent<IntelInfo>{
    public EmployeeProfileUpdatedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
