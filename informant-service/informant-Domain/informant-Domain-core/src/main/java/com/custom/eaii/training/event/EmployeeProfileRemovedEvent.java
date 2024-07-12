package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class EmployeeProfileRemovedEvent extends RemoveEmployeeProfileEvent<IntelInfo> {
    public EmployeeProfileRemovedEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
