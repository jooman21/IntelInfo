package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CancelPaymentCommand;
import com.custom.eaii.training.DTO.Create.CancelPaymentResponse;
import com.custom.eaii.training.event.PaymentCanceledEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelPaymentCommandHandler {
    private final PaymentCanceledCommandHelper paymentCanceledCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public CancelPaymentCommandHandler(PaymentCanceledCommandHelper paymentCanceledCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.paymentCanceledCommandHelper = paymentCanceledCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }


    public CancelPaymentResponse saveCanceledPayment(CancelPaymentCommand command){
        PaymentCanceledEvent paymentCanceledEvent = paymentCanceledCommandHelper.persistIntelInfo(command);
        log.info("Canceled Payment created with id: {}", paymentCanceledEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCancelPayment(
                paymentCanceledEvent.getIntelInfo(), "Canceled Payment created Successfully"
        );
    }
}
