package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.MakeDecisionCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.IntelInfoDeclinedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IntelInfoDeclinedCommandHelper {

    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public IntelInfoDeclinedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public IntelInfoDeclinedEvent persistIntelInfo(MakeDecisionCommand declineIntelInfoCommand){
        IntelInfo intelInfo = intelInfoDataMapper.declineIntelInfoCommandToIntelInfo(declineIntelInfoCommand);
        IntelInfoDeclinedEvent intelInfoDeclinedEvent = intelInfoDomainService.checkIfIntelInfoIsQualifiedTobeDeclined(intelInfo);
        saveIntelInfo(intelInfoDeclinedEvent.getIntelInfo());
        log.info("Intel Info is Declined with id:{}", intelInfoDeclinedEvent.getIntelInfo().getId().getValue());
        return intelInfoDeclinedEvent;
    }

    private void saveIntelInfo(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Intel Info");
            throw new IntelInfoDomainException("Could not save Intel Info");
        }
        log.info("Intel Info is saved with id: {}",
                result.getId().getValue());

    }
}
