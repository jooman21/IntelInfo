package com.custom.eaii.training.event;

import com.custom.eaii.training.entity.IntelInfo;

import java.time.ZonedDateTime;

public class Re_InitializedIntelInfoEvent extends Re_InitializeIntelInfoEvent<IntelInfo>{
    public Re_InitializedIntelInfoEvent(IntelInfo intelInfo, ZonedDateTime createdAt) {
        super(intelInfo, createdAt);
    }
}
