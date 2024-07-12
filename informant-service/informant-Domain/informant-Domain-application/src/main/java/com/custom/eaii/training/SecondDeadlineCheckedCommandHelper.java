package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.AskPaymentDeadlineCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.SecondDeadLineCheckedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecondDeadlineCheckedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public SecondDeadlineCheckedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public SecondDeadLineCheckedEvent persistIntelInfo(AskPaymentDeadlineCommand command) {
        IntelInfo intelInfo = intelInfoDataMapper.AskSecondPaymentDeadlineToIntelInfo(command);
        SecondDeadLineCheckedEvent secondDeadLineCheckedEvent = intelInfoDomainService.checkSecondDeadlineForInformantToReceivePayment(intelInfo);
        checkSecondDeadline(secondDeadLineCheckedEvent.getIntelInfo());
        log.info(" Second Deadline of Payment checked this  with id:{}", secondDeadLineCheckedEvent.getIntelInfo().getId().getValue());
        return secondDeadLineCheckedEvent;
    }

    private void checkSecondDeadline(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if (result == null) {
            log.error("Could not save Second  Deadline of payment");
            throw new IntelInfoDomainException("Could not save Second Deadline of payment");
        }
        log.info("Second Deadline of payment is saved with id: {}",
                result.getId().getValue());
    }
}
