package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.ReasonRegisterCommand;
import com.custom.eaii.training.DTO.Create.ReasonRegisterResponse;
import com.custom.eaii.training.event.ReasonRegisteredEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegisterReasonCommandHandler {
    private final ReasonRegisteredCommandHelper reasonRegisteredCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public RegisterReasonCommandHandler(ReasonRegisteredCommandHelper reasonRegisteredCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.reasonRegisteredCommandHelper = reasonRegisteredCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public ReasonRegisterResponse registerReason(ReasonRegisterCommand registerCommand){
        ReasonRegisteredEvent reasonRegisteredEvent = reasonRegisteredCommandHelper.persistIntelInfo(registerCommand);
        log.info("intel info is accepted with id: {}", reasonRegisteredEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToRegisterReasonResponse(
                reasonRegisteredEvent.getIntelInfo(), "Intel-Info created Successfully"
        );
    }


}
