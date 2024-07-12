package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateContactCommand;
import com.custom.eaii.training.entity.Contact;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.ContactUpdatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContactUpdatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public ContactUpdatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public ContactUpdatedEvent persistIntelInfo(CreateContactCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapContactCommandToIntelInfo(command);
        Contact newContact = intelInfo.getContact();
        ContactUpdatedEvent contactUpdatedEvent = intelInfoDomainService.validateAndUpdateContact(intelInfo,newContact);
        saveUpdatedContact(contactUpdatedEvent.getIntelInfo());
        log.info("Contact is created  with id:{}", contactUpdatedEvent.getIntelInfo().getId().getValue());
        return contactUpdatedEvent;
    }

    private void saveUpdatedContact(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save updated Contact");
            throw new IntelInfoDomainException("Could not save  Updated Contact");
        }
        log.info("Updated Contact is saved with id: {}",
                result.getId().getValue());

    }
}
