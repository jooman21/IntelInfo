package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.MakeDecisionCommand;
import com.custom.eaii.training.DTO.Create.MakeDecisionResponse;
import com.custom.eaii.training.event.IntelInfoAcceptedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AcceptIntelInfoCommandHandler {
    private final IntelInfoAcceptedCommandHelper intelInfoAcceptedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public AcceptIntelInfoCommandHandler(IntelInfoAcceptedCommandHelper intelInfoAcceptedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.intelInfoAcceptedCommandHelper = intelInfoAcceptedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public MakeDecisionResponse acceptIntelInfo(MakeDecisionCommand makeDecisionCommand){
        IntelInfoAcceptedEvent intelInfoAcceptedEvent = intelInfoAcceptedCommandHelper.persistIntelInfo(makeDecisionCommand);
        log.info("intel info is accepted with id: {}", intelInfoAcceptedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToAcceptIntelInfoResponse(
                intelInfoAcceptedEvent.getIntelInfo(), "AcceptIntelInfo created Successfully"
       );
    }


}
