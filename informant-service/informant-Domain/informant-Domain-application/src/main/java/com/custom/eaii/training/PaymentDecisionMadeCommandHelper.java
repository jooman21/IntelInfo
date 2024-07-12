package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.MakeAllowedPaymentDecisionCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.AllowedPaymentDecisionMadeEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentDecisionMadeCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public PaymentDecisionMadeCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public AllowedPaymentDecisionMadeEvent persistIntelInfo(MakeAllowedPaymentDecisionCommand command) {
        IntelInfo intelInfo = intelInfoDataMapper.MakeAllowedPaymentDecisionToIntelInfo(command);
        AllowedPaymentDecisionMadeEvent allowedPaymentDecisionMadeEvent = intelInfoDomainService.makeAllowedPaymentDecision(intelInfo);
        saveAllowedPaymentDecision(allowedPaymentDecisionMadeEvent.getIntelInfo());
        log.info("Allowed Payment Decision is registered with id:{}", allowedPaymentDecisionMadeEvent.getIntelInfo().getId().getValue());
        return allowedPaymentDecisionMadeEvent;
    }

    private void saveAllowedPaymentDecision(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save AllowedPayment Decision");
            throw new IntelInfoDomainException("Could not save AllowedPayment Decision");
        }
        log.info("AllowedPayment Decision is saved with id: {}",
                result.getId().getValue());

    }
}
