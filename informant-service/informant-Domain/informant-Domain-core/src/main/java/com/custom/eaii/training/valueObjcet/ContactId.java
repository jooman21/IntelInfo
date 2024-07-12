package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class ContactId extends BaseId<UUID> {
    public ContactId(UUID value) {
        super(value);
    }

}
