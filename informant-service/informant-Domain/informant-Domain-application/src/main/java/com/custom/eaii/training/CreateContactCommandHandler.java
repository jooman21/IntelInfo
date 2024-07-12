package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateContactCommand;
import com.custom.eaii.training.DTO.Create.CreateContactResponse;
import com.custom.eaii.training.event.ContactCreatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateContactCommandHandler {
    private final ContactCreatedCommandHelper contactCreatedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public CreateContactCommandHandler(ContactCreatedCommandHelper contactCreatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.contactCreatedCommandHelper = contactCreatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CreateContactResponse createContact(CreateContactCommand command){
    ContactCreatedEvent contactCreatedEvent = contactCreatedCommandHelper.persistIntelInfo(command);
    log.info("Contact is created with id: {}", contactCreatedEvent.getIntelInfo().getId().getValue());
    return  intelInfoDataMapper.intelInfoToCreateContact(
            contactCreatedEvent.getIntelInfo(), "Contact is created Successfully"
    );
}
}
