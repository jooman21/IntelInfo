package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CancelPaymentCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.PaymentCanceledEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentCanceledCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public PaymentCanceledCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public PaymentCanceledEvent persistIntelInfo(CancelPaymentCommand Command) {
        IntelInfo intelInfo = intelInfoDataMapper.CancelPaymentToIntelInfo(Command);
        PaymentCanceledEvent paymentCanceledEvent = intelInfoDomainService.cancelReceivingPaymentIfItIsExpired(intelInfo);
        saveCanceledPayment(paymentCanceledEvent.getIntelInfo());
        log.info("Payment canceled with id:{}", paymentCanceledEvent.getIntelInfo().getId().getValue());
        return paymentCanceledEvent;
    }

    private void saveCanceledPayment(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Canceled Payment");
            throw new IntelInfoDomainException("Could not save  Canceled Payment");
        }
        log.info("Canceled Payment is saved with id: {}",
                result.getId().getValue());

    }
}
