package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.MakeDecisionCommand;
import com.custom.eaii.training.DTO.Create.ReInitializeIntelInfoResponse;
import com.custom.eaii.training.event.Re_InitializedIntelInfoEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReInitializeIntelInfoCommandHandler {
    private final IntelInfoReInitializedCommandHelper intelInfoReInitializedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public ReInitializeIntelInfoCommandHandler(IntelInfoReInitializedCommandHelper intelInfoReInitializedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.intelInfoReInitializedCommandHelper = intelInfoReInitializedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public ReInitializeIntelInfoResponse re_InitializedIntelInfo(MakeDecisionCommand re_InitializedIntelInfoCommand){
        Re_InitializedIntelInfoEvent reInitializedIntelInfoEvent = intelInfoReInitializedCommandHelper.persistIntelInfo(re_InitializedIntelInfoCommand);
        log.info("IntelInfo re-initialized with id: {}", reInitializedIntelInfoEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToRe_InitializedIntelInfoResponse(
                reInitializedIntelInfoEvent.getIntelInfo(), "IntelInfo re-initialized created Successfully"
        );
    }
}
