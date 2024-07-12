package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.RegisterCauseCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.PaymentDeclinedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentDeclinedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public PaymentDeclinedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public PaymentDeclinedEvent persistIntelInfo(RegisterCauseCommand Command) {
        IntelInfo intelInfo = intelInfoDataMapper.RegisterCauseToIntelInfo(Command);
        PaymentDeclinedEvent paymentDeclinedEvent = intelInfoDomainService.registerDeclinedPaymentReason(intelInfo);
        saveDeclinedPayment(paymentDeclinedEvent.getIntelInfo());
        log.info("DeclinedPayment is registered with id:{}", paymentDeclinedEvent.getIntelInfo().getId().getValue());
        return paymentDeclinedEvent;
    }

    private void saveDeclinedPayment(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save declined payment");
            throw new IntelInfoDomainException("Could not save declined payment");
        }
        log.info("declined payment is saved with id: {}",
                result.getId().getValue());

    }
}
