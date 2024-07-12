package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateIntelInfoResponse;
import com.custom.eaii.training.DTO.Create.RegisterIntelInfoCommand;
import com.custom.eaii.training.event.IntelInfoRegisteredEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegisterIntelInfoCommandHandler {

    private final IntelInfoRegisteredCommandHelper intelInfoRegisteredCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public RegisterIntelInfoCommandHandler(IntelInfoRegisteredCommandHelper intelInfoRegisteredCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.intelInfoRegisteredCommandHelper = intelInfoRegisteredCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CreateIntelInfoResponse handleCreateIntelInfo(RegisterIntelInfoCommand registerIntelInfoCommand){
        IntelInfoRegisteredEvent intelInfoRegisteredEvent = intelInfoRegisteredCommandHelper.persistIntelInfo(registerIntelInfoCommand);
        log.info("intel info is created with id: {}", intelInfoRegisteredEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToRegisterIntelInfoResponse(
                intelInfoRegisteredEvent.getIntelInfo(), "Intel-Info created Successfully"
        );
    }
}
