package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateFinanceOfficerCommand;
import com.custom.eaii.training.entity.FinanceOfficerProfile;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.FinanceOfficerProfileUpdatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FinanceProfileOfficerUpdatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public FinanceProfileOfficerUpdatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public FinanceOfficerProfileUpdatedEvent persistIntelInfo(CreateFinanceOfficerCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapFinanceCommandToIntelInfo(command);
        FinanceOfficerProfile newProfile = intelInfo.getFinanceOfficerProfile();
        FinanceOfficerProfileUpdatedEvent financeOfficerProfileUpdatedEvent = intelInfoDomainService.validateAndUpdateFinanceProfile(intelInfo,newProfile);
        saveUpdatedFinanceOfficerProfile(financeOfficerProfileUpdatedEvent.getIntelInfo());
        log.info("Finance profile is created  with id:{}", financeOfficerProfileUpdatedEvent.getIntelInfo().getId().getValue());
        return financeOfficerProfileUpdatedEvent;
    }

    private void saveUpdatedFinanceOfficerProfile(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save updated FinanceOfficerProfile");
            throw new IntelInfoDomainException("Could not save updated FinanceOfficerProfile");
        }
        log.info("Updated FinanceOfficerProfile  is saved with id: {}",
                result.getId().getValue());

    }
}
