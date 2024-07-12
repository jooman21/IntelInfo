package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateContactCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.ContactCreatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContactCreatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public ContactCreatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public ContactCreatedEvent persistIntelInfo(CreateContactCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapContactCommandToIntelInfo(command);
        ContactCreatedEvent contactCreatedEvent = intelInfoDomainService.validateAndCreateContact(intelInfo);
        saveCreatedContact(contactCreatedEvent.getIntelInfo());
        log.info("Contact is created  with id:{}", contactCreatedEvent.getIntelInfo().getId().getValue());
        return contactCreatedEvent;
    }

    private void saveCreatedContact(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Contact");
            throw new IntelInfoDomainException("Could not save  Contact");
        }
        log.info("Contact is saved with id: {}",
                result.getId().getValue());

    }
}
