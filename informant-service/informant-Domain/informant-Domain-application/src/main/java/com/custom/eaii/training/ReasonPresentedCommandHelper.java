package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.PresentReasonCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.ReasonPresentedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReasonPresentedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public ReasonPresentedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public ReasonPresentedEvent persistIntelInfo(PresentReasonCommand Command) {
        IntelInfo intelInfo = intelInfoDataMapper.PresentReasonToIntelInfo(Command);
        ReasonPresentedEvent reasonPresentedEvent = intelInfoDomainService.presentInformantReason(intelInfo);
        savePresentedReason(reasonPresentedEvent.getIntelInfo());
        log.info("Informant Reason  is presented with id:{}", reasonPresentedEvent.getIntelInfo().getId().getValue());
        return reasonPresentedEvent;
    }

    private void savePresentedReason(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Presented Reason");
            throw new IntelInfoDomainException("Could not save Presented Reason");
        }
        log.info("Presented Reason is saved with id: {}",
                result.getId().getValue());

    }
}
