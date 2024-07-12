package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class IntelInfoId extends BaseId<UUID> {
    public IntelInfoId(UUID value) {
        super(value);
    }
}
