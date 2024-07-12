package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.AskPaymentDeadlineCommand;
import com.custom.eaii.training.DTO.Create.AskPaymentDeadlineResponse;
import com.custom.eaii.training.event.DeadLineCheckedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CheckDeadlineCommandHandler {


    private final   DeadlineCheckedCommandHelper deadlineCheckedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public CheckDeadlineCommandHandler(DeadlineCheckedCommandHelper deadlineCheckedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.deadlineCheckedCommandHelper = deadlineCheckedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public AskPaymentDeadlineResponse checkPaymentDeadline(AskPaymentDeadlineCommand command){
        DeadLineCheckedEvent deadLineCheckedEvent = deadlineCheckedCommandHelper.persistIntelInfo(command);
        log.info("Payment Deadline checked  with id: {}", deadLineCheckedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToAskPaymentDeadline(
                deadLineCheckedEvent.getIntelInfo(), "Payment Deadline checked  created Successfully"
        );
    }
}
