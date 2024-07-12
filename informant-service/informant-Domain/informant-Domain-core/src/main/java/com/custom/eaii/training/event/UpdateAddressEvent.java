package com.custom.eaii.training.event;

import com.custom.eaii.training.domain.event.DomainEvent;
import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class UpdateAddressEvent <p> implements DomainEvent<IntelInfo> {
    private final IntelInfo intelInfo;
    private final ZonedDateTime createdAt;

    public UpdateAddressEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        this.intelInfo = intelInfo;
        this.createdAt = createdAt;
    }

    public IntelInfo getIntelInfo() {
        return intelInfo;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
