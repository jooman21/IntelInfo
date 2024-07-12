package com.custom.eaii.training.valueObjcet;

import com.custom.eaii.training.domain.valueobject.BaseId;

import java.util.UUID;

public class EmployeeProfileId extends BaseId<UUID> {
    public EmployeeProfileId(UUID value) {
        super(value);
    }
}
