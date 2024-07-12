package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class AllowedPaymentDecisionMadeEvent extends MakeAllowedPaymentDecisionEvent<IntelInfo> {
    public AllowedPaymentDecisionMadeEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
