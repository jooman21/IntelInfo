package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.MakeAllowedPaymentDecisionCommand;
import com.custom.eaii.training.DTO.Create.MakeAllowedPaymentDecisionResponse;
import com.custom.eaii.training.event.AllowedPaymentDecisionMadeEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MakeAllowedPaymentDecisionCommandHandler {

    private final PaymentDecisionMadeCommandHelper paymentDecisionMadeCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public MakeAllowedPaymentDecisionCommandHandler(PaymentDecisionMadeCommandHelper paymentDecisionMadeCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.paymentDecisionMadeCommandHelper = paymentDecisionMadeCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public MakeAllowedPaymentDecisionResponse savePaymentDecision(MakeAllowedPaymentDecisionCommand command){
        AllowedPaymentDecisionMadeEvent allowedPaymentDecisionMadeEvent = paymentDecisionMadeCommandHelper.persistIntelInfo(command);
        log.info("intel info is created with id: {}", allowedPaymentDecisionMadeEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToMakeAllowedPaymentDecision(
                allowedPaymentDecisionMadeEvent.getIntelInfo(), "Intel-Info created Successfully"
        );
    }
}
