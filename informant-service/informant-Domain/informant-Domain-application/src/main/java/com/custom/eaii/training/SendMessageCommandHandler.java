package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.SendMessageCommand;
import com.custom.eaii.training.DTO.Create.SendMessageResponse;
import com.custom.eaii.training.event.MessageSentEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendMessageCommandHandler {
    private final MessageSentCommandHelper messageSentCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public SendMessageCommandHandler(MessageSentCommandHelper messageSentCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.messageSentCommandHelper = messageSentCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public SendMessageResponse checkMessageSent(SendMessageCommand sendMessageCommand){
        MessageSentEvent messageSentEvent = messageSentCommandHelper.persistIntelInfo(sendMessageCommand);
        log.info("Message sent with id: {}", messageSentEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToSendMessageResponse(
                messageSentEvent.getIntelInfo(), "Message sent created Successfully"
        );
    }
}
