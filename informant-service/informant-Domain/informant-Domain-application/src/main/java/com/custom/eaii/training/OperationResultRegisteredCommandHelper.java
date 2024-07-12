package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.RegisterOperationResultCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.OperationResultRegisteredEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OperationResultRegisteredCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public OperationResultRegisteredCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public OperationResultRegisteredEvent persistIntelInfo(RegisterOperationResultCommand command) {
        IntelInfo intelInfo = intelInfoDataMapper.RegisterOperationResultToIntelInfo(command);
        OperationResultRegisteredEvent operationResultRegisteredEvent = intelInfoDomainService.checkOperationIsSuccessful(intelInfo);
        saveOperationResult(operationResultRegisteredEvent.getIntelInfo());
        log.info("Operation Result is registered with id:{}", operationResultRegisteredEvent.getIntelInfo().getId().getValue());
        return operationResultRegisteredEvent;
    }

    private void saveOperationResult(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Operation Result");
            throw new IntelInfoDomainException("Could not Operation Result");
        }
        log.info("Operation Result saved  saved with id: {}",
                result.getId().getValue());

    }
}
