package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class FinanceOfficerId extends BaseId<UUID> {
    public FinanceOfficerId(UUID value) {
        super(value);
    }
}
