package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.ReasonRegisterCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.ReasonRegisteredEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReasonRegisteredCommandHelper {

    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public ReasonRegisteredCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public ReasonRegisteredEvent persistIntelInfo(ReasonRegisterCommand registerCommand) {
        IntelInfo intelInfo = intelInfoDataMapper.RegisterReasonIntelInfoCommandToIntelInfo(registerCommand);
        ReasonRegisteredEvent reasonRegisteredEvent = intelInfoDomainService.checkDeclineReasonIsQualifiedToBeRegistered(intelInfo);
        saveRegisteredReason(reasonRegisteredEvent.getIntelInfo());
        log.info("Declined Intel Info is registered with id:{}", reasonRegisteredEvent.getIntelInfo().getId().getValue());
        return reasonRegisteredEvent;
    }

    private void saveRegisteredReason(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Intel Info");
            throw new IntelInfoDomainException("Could not save Intel Info");
        }
        log.info("Intel Info is saved with id: {}",
                result.getId().getValue());

    }
}
