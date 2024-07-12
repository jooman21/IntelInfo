package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class PaymentId extends BaseId <UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
