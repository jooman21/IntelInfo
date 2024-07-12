package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.AskPaymentDeadlineCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.DeadLineCheckedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeadlineCheckedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public DeadlineCheckedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }


    @Transactional
    public DeadLineCheckedEvent persistIntelInfo(AskPaymentDeadlineCommand command) {
        IntelInfo intelInfo = intelInfoDataMapper.AskPaymentDeadlineToIntelInfo(command);
        DeadLineCheckedEvent deadLineCheckedEvent = intelInfoDomainService.checkDeadlineForInformantToReceivePayment(intelInfo);
        checkDeadline(deadLineCheckedEvent.getIntelInfo());
        log.info("Deadline of Payment checked this  with id:{}", deadLineCheckedEvent.getIntelInfo().getId().getValue());
        return deadLineCheckedEvent;
    }

    private void checkDeadline(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if (result == null) {
            log.error("Could not save Deadline of payment");
            throw new IntelInfoDomainException("Could not save Deadline of payment");
        }
        log.info("Deadline of payment is saved with id: {}",
                result.getId().getValue());
    }
}