package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.MakeDecisionCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.IntelInfoAcceptedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IntelInfoAcceptedCommandHelper {

    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public IntelInfoAcceptedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
     public IntelInfoAcceptedEvent persistIntelInfo(MakeDecisionCommand makeDecisionCommand){
        IntelInfo intelInfo = intelInfoDataMapper.acceptIntelInfoCommandToIntelInfo(makeDecisionCommand);
        IntelInfoAcceptedEvent intelInfoAcceptedEvent = intelInfoDomainService.checkIfIntelInfoIsQualifiedTobeAccepted(intelInfo);
        saveAcceptedIntelInfo(intelInfoAcceptedEvent.getIntelInfo());
         log.info("Intel Info is Accepted with id:{}", intelInfoAcceptedEvent.getIntelInfo().getId().getValue());
        return intelInfoAcceptedEvent;
     }

       private void saveAcceptedIntelInfo(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Accepted Intel Info");
            throw new IntelInfoDomainException("Could not save Accepted Intel Info");
        }
        log.info("Intel Info is saved with id: {}",
                result.getId().getValue());

    }



}
