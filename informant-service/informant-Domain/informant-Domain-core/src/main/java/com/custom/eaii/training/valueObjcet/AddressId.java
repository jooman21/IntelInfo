package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class AddressId extends BaseId<UUID> {
    public AddressId(UUID value) {
        super(value);
    }
}
