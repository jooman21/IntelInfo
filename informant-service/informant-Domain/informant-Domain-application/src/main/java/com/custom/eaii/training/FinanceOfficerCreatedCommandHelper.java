package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateFinanceOfficerCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.FinanceOfficerProfileCreatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FinanceOfficerCreatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public FinanceOfficerCreatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public FinanceOfficerProfileCreatedEvent persistIntelInfo(CreateFinanceOfficerCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapFinanceCommandToIntelInfo(command);
        FinanceOfficerProfileCreatedEvent financeOfficerProfileCreatedEvent = intelInfoDomainService.validateAndCreateProfile(intelInfo);
        saveCreatedFinanceOfficer(financeOfficerProfileCreatedEvent.getIntelInfo());
        log.info("Finance Officer is created  with id:{}", financeOfficerProfileCreatedEvent.getIntelInfo().getId().getValue());
        return financeOfficerProfileCreatedEvent;
    }

    private void saveCreatedFinanceOfficer(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Finance Officer");
            throw new IntelInfoDomainException("Could not save  Finance Officer");
        }
        log.info("Finance Officer is saved with id: {}",
                result.getId().getValue());

    }
}
