package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateComplainResponse;
import com.custom.eaii.training.DTO.Create.PresentComplaintCommand;
import com.custom.eaii.training.event.ComplainAcceptedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AcceptComplainCommandHandler {
    private final ComplainAcceptedCommandHelper complainAcceptedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public AcceptComplainCommandHandler(ComplainAcceptedCommandHelper complainAcceptedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.complainAcceptedCommandHelper = complainAcceptedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CreateComplainResponse saveAcceptedComplaint(PresentComplaintCommand presentComplaintCommand){
        ComplainAcceptedEvent complainAcceptedEvent = complainAcceptedCommandHelper.persistIntelInfo(presentComplaintCommand);
        log.info("Complain is accepted with id: {}", complainAcceptedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToAcceptComplainResponse(
                complainAcceptedEvent.getIntelInfo(), "AcceptIntelInfo created Successfully"
        );
    }


}
