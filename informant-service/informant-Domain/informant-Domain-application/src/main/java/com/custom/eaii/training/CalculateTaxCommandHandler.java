package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CalculateTaxCommand;
import com.custom.eaii.training.DTO.Create.CalculateTaxResponse;
import com.custom.eaii.training.event.TaxCalculatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculateTaxCommandHandler {

    private final   TaxCalculatedCommandHelper taxCalculatedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public CalculateTaxCommandHandler(TaxCalculatedCommandHelper taxCalculatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.taxCalculatedCommandHelper = taxCalculatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CalculateTaxResponse TaxIsCalculated(CalculateTaxCommand command){
        TaxCalculatedEvent taxCalculatedEvent = taxCalculatedCommandHelper.persistIntelInfo(command);
        log.info("Tax Calculated with id: {}", taxCalculatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCalculatedTaxResponse(
                taxCalculatedEvent.getIntelInfo(), "Calculated Tax created Successfully"
        );
    }
}
