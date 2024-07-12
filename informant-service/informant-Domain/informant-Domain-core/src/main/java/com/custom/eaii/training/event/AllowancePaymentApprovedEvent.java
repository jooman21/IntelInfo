package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class AllowancePaymentApprovedEvent extends ApproveAllowancePaymentEvent<IntelInfo>{
    public AllowancePaymentApprovedEvent(IntelInfo intelInfo, String string, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
