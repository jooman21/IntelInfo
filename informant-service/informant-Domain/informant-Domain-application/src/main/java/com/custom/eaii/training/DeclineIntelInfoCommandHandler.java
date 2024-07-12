package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.DeclineIntelInfoResponse;
import com.custom.eaii.training.DTO.Create.MakeDecisionCommand;
import com.custom.eaii.training.event.IntelInfoDeclinedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeclineIntelInfoCommandHandler {
    private final IntelInfoDeclinedCommandHelper intelInfoDeclinedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public DeclineIntelInfoCommandHandler(IntelInfoDeclinedCommandHelper intelInfoDeclinedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.intelInfoDeclinedCommandHelper = intelInfoDeclinedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }
    public DeclineIntelInfoResponse declineIntelInfo(MakeDecisionCommand declineIntelInfoCommand){
        IntelInfoDeclinedEvent intelInfoDeclinedEvent = intelInfoDeclinedCommandHelper.persistIntelInfo(declineIntelInfoCommand);
        log.info("intel info is accepted with id: {}", intelInfoDeclinedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToDeclineIntelInfoResponse(
                intelInfoDeclinedEvent.getIntelInfo(), "DeclineIntelInfo created Successfully"
        );
    }
}
