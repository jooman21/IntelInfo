package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateFinanceOfficerCommand;
import com.custom.eaii.training.DTO.Create.CreateFinanceOfficerResponse;
import com.custom.eaii.training.event.FinanceOfficerProfileCreatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateFinanceOfficerCommandHandler {

    private final IntelInfoDataMapper intelInfoDataMapper;

    private final FinanceOfficerCreatedCommandHelper financeOfficerCreatedCommandHelper;

    public CreateFinanceOfficerCommandHandler(IntelInfoDataMapper intelInfoDataMapper, FinanceOfficerCreatedCommandHelper financeOfficerCreatedCommandHelper) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.financeOfficerCreatedCommandHelper = financeOfficerCreatedCommandHelper;
    }

    public CreateFinanceOfficerResponse createFinanceProfile(CreateFinanceOfficerCommand command){
        FinanceOfficerProfileCreatedEvent financeOfficerProfileCreatedEvent = financeOfficerCreatedCommandHelper.persistIntelInfo(command);
        log.info("Finance Officer is created  with id: {}", financeOfficerProfileCreatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCreateFinanceOfficer(
                financeOfficerProfileCreatedEvent.getIntelInfo(), "Finance Officer is  created Successfully"
        );
    }
}
