package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateContactCommand;
import com.custom.eaii.training.DTO.Create.CreateContactResponse;
import com.custom.eaii.training.event.ContactUpdatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateContactCommandHandler {

    private final ContactUpdatedCommandHelper contactUpdatedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public UpdateContactCommandHandler(ContactUpdatedCommandHelper contactUpdatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.contactUpdatedCommandHelper = contactUpdatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CreateContactResponse updateContact(CreateContactCommand command){
        ContactUpdatedEvent contactUpdatedEvent = contactUpdatedCommandHelper.persistIntelInfo(command);
        log.info("Contact is updated with id: {}", contactUpdatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCreateContact(
                contactUpdatedEvent.getIntelInfo(), "Contact is updated Successfully"
        );
    }
}
