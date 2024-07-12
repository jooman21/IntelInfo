package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CalculateAllowanceCommand;
import com.custom.eaii.training.DTO.Create.CalculateAllowanceResponse;
import com.custom.eaii.training.event.AllowancePaymentApprovedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculateAllowanceCommandHandler {
    private final   AllowanceCalculatedCommandHelper allowanceCalculatedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public CalculateAllowanceCommandHandler(AllowanceCalculatedCommandHelper allowanceCalculatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.allowanceCalculatedCommandHelper = allowanceCalculatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CalculateAllowanceResponse AllowancePaymentIsCalculated(CalculateAllowanceCommand command){
        AllowancePaymentApprovedEvent allowancePaymentApprovedEvent = allowanceCalculatedCommandHelper.persistIntelInfo(command);
        log.info("Allowance is Calculated with id: {}", allowancePaymentApprovedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCalculatedAllowanceResponse(
                allowancePaymentApprovedEvent.getIntelInfo(), "Calculated Allowance created Successfully"
        );
    }
}
