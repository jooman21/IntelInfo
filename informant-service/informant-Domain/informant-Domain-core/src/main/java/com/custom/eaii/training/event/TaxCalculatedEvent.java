package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class TaxCalculatedEvent extends CalculateTaxEvent<IntelInfo>{
    public TaxCalculatedEvent(IntelInfo intelInfo, String string, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
