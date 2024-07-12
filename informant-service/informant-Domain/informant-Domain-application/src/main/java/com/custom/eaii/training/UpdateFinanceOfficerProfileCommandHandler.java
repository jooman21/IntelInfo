package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateFinanceOfficerCommand;
import com.custom.eaii.training.DTO.Create.CreateFinanceOfficerResponse;
import com.custom.eaii.training.event.FinanceOfficerProfileUpdatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateFinanceOfficerProfileCommandHandler {
    private final FinanceProfileOfficerUpdatedCommandHelper financeProfileOfficerUpdatedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public UpdateFinanceOfficerProfileCommandHandler(FinanceProfileOfficerUpdatedCommandHelper financeProfileOfficerUpdatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.financeProfileOfficerUpdatedCommandHelper = financeProfileOfficerUpdatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }
    public CreateFinanceOfficerResponse updateFinanceProfile(CreateFinanceOfficerCommand command){
        FinanceOfficerProfileUpdatedEvent financeOfficerProfileUpdatedEvent = financeProfileOfficerUpdatedCommandHelper.persistIntelInfo(command);
        log.info("FinanceOfficer Profile is updated with id: {}", financeOfficerProfileUpdatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCreateFinanceOfficer(
                financeOfficerProfileUpdatedEvent.getIntelInfo(), "FinanceOfficer Profile is updated Successfully"
        );
    }
}
