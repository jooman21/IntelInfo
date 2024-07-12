package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class InformantProfileId extends BaseId<UUID> {
    public InformantProfileId(UUID value) {
        super(value);
    }
}
