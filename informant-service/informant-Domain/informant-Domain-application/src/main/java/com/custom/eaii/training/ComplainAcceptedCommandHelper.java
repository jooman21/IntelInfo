package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.PresentComplaintCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.ComplainAcceptedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ComplainAcceptedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public ComplainAcceptedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public ComplainAcceptedEvent persistIntelInfo(PresentComplaintCommand presentComplaintCommand){


        IntelInfo intelInfo = intelInfoDataMapper.AcceptComplaintCommandToIntelInfo(presentComplaintCommand);
        ComplainAcceptedEvent complainAcceptedEvent = intelInfoDomainService.checkIfCompliantIsQualifiedTobeAccepted(intelInfo);
        saveAcceptedComplain(complainAcceptedEvent.getIntelInfo());
        log.info("Complain  is Accepted with id:{}", complainAcceptedEvent.getIntelInfo().getId().getValue());
        return complainAcceptedEvent;
    }

    private void saveAcceptedComplain(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Accepted Complain");
            throw new IntelInfoDomainException("Could not save Accepted Complain");
        }
        log.info("Accepted Complain is saved with id: {}",
                result.getId().getValue());

    }
}
