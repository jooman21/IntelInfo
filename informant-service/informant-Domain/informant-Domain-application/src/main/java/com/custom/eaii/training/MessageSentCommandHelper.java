package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.SendMessageCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.MessageSentEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSentCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public MessageSentCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public MessageSentEvent persistIntelInfo(SendMessageCommand sendMessageCommand) {
        IntelInfo intelInfo = intelInfoDataMapper.SendMessageCommandToIntelInfo(sendMessageCommand);
        MessageSentEvent messageSentEvent = intelInfoDomainService.sendMessageToInformantAndHigherOfficials(intelInfo);
        saveMessageSent(messageSentEvent.getIntelInfo());
        log.info("Declined Intel Info is registered with id:{}", messageSentEvent.getIntelInfo().getId().getValue());
        return messageSentEvent;
    }

    private void saveMessageSent(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Sent Message");
            throw new IntelInfoDomainException("Could not save Sent Message");
        }
        log.info("Intel Info is saved with id: {}",
                result.getId().getValue());

    }
}
