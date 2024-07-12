package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class OperationId extends BaseId <UUID> {
    public OperationId(UUID value) {
        super(value);
    }
}
