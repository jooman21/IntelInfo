package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.RegisterOperationResultCommand;
import com.custom.eaii.training.DTO.Create.RegisterOperationResultResponse;
import com.custom.eaii.training.event.OperationResultRegisteredEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegisterOperationResultCommandHandler {
    private final OperationResultRegisteredCommandHelper operationResultRegisteredCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public RegisterOperationResultCommandHandler(OperationResultRegisteredCommandHelper operationResultRegisteredCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.operationResultRegisteredCommandHelper = operationResultRegisteredCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public RegisterOperationResultResponse SaveOperationResult(RegisterOperationResultCommand command){
        OperationResultRegisteredEvent operationResultRegisteredEvent = operationResultRegisteredCommandHelper.persistIntelInfo(command);
        log.info("IntelInfo re-initialized with id: {}", operationResultRegisteredEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToRegisterOperationResultResponse(
                operationResultRegisteredEvent.getIntelInfo(), "IntelInfo re-initialized created Successfully"
        );
    }
}
