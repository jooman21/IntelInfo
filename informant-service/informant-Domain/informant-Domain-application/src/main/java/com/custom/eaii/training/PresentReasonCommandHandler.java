package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.PresentReasonCommand;
import com.custom.eaii.training.DTO.Create.PresentReasonResponse;
import com.custom.eaii.training.event.ReasonPresentedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PresentReasonCommandHandler {

    private final ReasonPresentedCommandHelper reasonPresentedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public PresentReasonCommandHandler(ReasonPresentedCommandHelper reasonPresentedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.reasonPresentedCommandHelper = reasonPresentedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }
    public PresentReasonResponse savePresentedReason(PresentReasonCommand command){
        ReasonPresentedEvent reasonPresentedEvent = reasonPresentedCommandHelper.persistIntelInfo(command);
        log.info("intel info is created with id: {}", reasonPresentedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToPresentReason(
                reasonPresentedEvent.getIntelInfo(), "Intel-Info created Successfully"
        );
    }
}
