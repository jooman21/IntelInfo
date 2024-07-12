package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class PaymentCanceledEvent extends CancelPaymentEvent<IntelInfo>{
    public PaymentCanceledEvent(IntelInfo intelInfo, String createdAt) {
        super(intelInfo, ZonedDateTime.parse(createdAt));
    }
}
