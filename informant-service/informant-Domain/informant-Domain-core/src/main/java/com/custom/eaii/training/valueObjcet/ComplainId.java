package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class ComplainId extends BaseId<UUID> {
    public ComplainId(UUID value) {
        super(value);
    }
}
