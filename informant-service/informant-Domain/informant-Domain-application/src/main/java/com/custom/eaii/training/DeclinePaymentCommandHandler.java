package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.RegisterCauseCommand;
import com.custom.eaii.training.DTO.Create.RegisterCauseResponse;
import com.custom.eaii.training.event.PaymentDeclinedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeclinePaymentCommandHandler {
    private final PaymentDeclinedCommandHelper paymentDeclinedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public DeclinePaymentCommandHandler(PaymentDeclinedCommandHelper paymentDeclinedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.paymentDeclinedCommandHelper = paymentDeclinedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public RegisterCauseResponse saveDeclinedPayment(RegisterCauseCommand command){
        PaymentDeclinedEvent paymentDeclinedEvent = paymentDeclinedCommandHelper.persistIntelInfo(command);
        log.info("Declined Payment created with id: {}", paymentDeclinedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToRegisterDeclinedCause(
                paymentDeclinedEvent.getIntelInfo(), "Declined created Successfully"
        );
    }
}
