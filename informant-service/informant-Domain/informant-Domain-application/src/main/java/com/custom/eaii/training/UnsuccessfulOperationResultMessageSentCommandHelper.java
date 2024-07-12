package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.SendMessageCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.UnsuccessfulOperationResultMessageSentEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UnsuccessfulOperationResultMessageSentCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public UnsuccessfulOperationResultMessageSentCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public UnsuccessfulOperationResultMessageSentEvent persistIntelInfo(SendMessageCommand command) {
        IntelInfo intelInfo = intelInfoDataMapper.SendOperationResultMessageCommandToIntelInfo(command);
        UnsuccessfulOperationResultMessageSentEvent unsuccessfulOperationResultMessageSentEvent = intelInfoDomainService.sendOperationResultToInformantAndHigherOfficials(intelInfo);
        sendUnsuccessfulOperationResult(unsuccessfulOperationResultMessageSentEvent.getIntelInfo());
        log.info(" Unsuccessful Operation Result is sent with id:{}", unsuccessfulOperationResultMessageSentEvent.getIntelInfo().getId().getValue());
        return unsuccessfulOperationResultMessageSentEvent;
    }

    private void sendUnsuccessfulOperationResult(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Unsuccessful Operation Result");
            throw new IntelInfoDomainException("Could not save Unsuccessful Operation Result");
        }
        log.info("Unsuccessful Operation Result saved  saved with id: {}",
                result.getId().getValue());

    }
}
