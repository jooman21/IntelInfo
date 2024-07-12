package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.AskPaymentDeadlineCommand;
import com.custom.eaii.training.DTO.Create.AskPaymentDeadlineResponse;
import com.custom.eaii.training.event.SecondDeadLineCheckedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CheckSecondDeadlineCommandHandler {
    private final SecondDeadlineCheckedCommandHelper secondDeadlineCheckedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public CheckSecondDeadlineCommandHandler(SecondDeadlineCheckedCommandHelper secondDeadlineCheckedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.secondDeadlineCheckedCommandHelper = secondDeadlineCheckedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public AskPaymentDeadlineResponse checkSecondPaymentDeadline(AskPaymentDeadlineCommand command){
        SecondDeadLineCheckedEvent secondDeadLineCheckedEvent = secondDeadlineCheckedCommandHelper.persistIntelInfo(command);
        log.info("Payment Second Deadline checked  with id: {}", secondDeadLineCheckedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToAskPaymentDeadline(
                secondDeadLineCheckedEvent.getIntelInfo(), "Payment Second Deadline checked  created Successfully"
        );
    }
}
