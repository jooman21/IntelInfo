package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.SendMessageCommand;
import com.custom.eaii.training.DTO.Create.SendUnsuccessfulOperationResultMessageResponse;
import com.custom.eaii.training.event.UnsuccessfulOperationResultMessageSentEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j

@Component
public class SendUnsuccessfulOperationResultMessageCommandHandler {
    private final UnsuccessfulOperationResultMessageSentCommandHelper unsuccessfulOperationResultMessageSentCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public SendUnsuccessfulOperationResultMessageCommandHandler( UnsuccessfulOperationResultMessageSentCommandHelper unsuccessfulOperationResultMessageSentCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.unsuccessfulOperationResultMessageSentCommandHelper = unsuccessfulOperationResultMessageSentCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public SendUnsuccessfulOperationResultMessageResponse  SendUnsuccessfulOperationResultMessage(SendMessageCommand command){
        UnsuccessfulOperationResultMessageSentEvent unsuccessfulOperationResultMessageSentEvent = unsuccessfulOperationResultMessageSentCommandHelper.persistIntelInfo(command);
        log.info("intel info is accepted with id: {}", unsuccessfulOperationResultMessageSentEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToSendMessageOfOperationResultResponse(
                unsuccessfulOperationResultMessageSentEvent.getIntelInfo(), "Unsuccessful Operation result created Successfully"
        );
    }
}
