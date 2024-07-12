package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class PaymentDeclinedEvent extends DeclinePaymentEvent<IntelInfo>{
    public PaymentDeclinedEvent(IntelInfo intelInfo, String createdAt) {
        super(intelInfo, ZonedDateTime.parse(createdAt));
    }
}
