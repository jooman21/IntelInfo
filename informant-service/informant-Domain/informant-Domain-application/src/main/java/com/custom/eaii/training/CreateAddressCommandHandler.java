package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateAddressCommand;
import com.custom.eaii.training.DTO.Create.CreateAddressResponse;
import com.custom.eaii.training.event.AddressCreatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateAddressCommandHandler {
    private final AddressCreatedCommandHelper addressCreatedCommandHelper;

    private final IntelInfoDataMapper intelInfoDataMapper;

    public CreateAddressCommandHandler(AddressCreatedCommandHelper addressCreatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.addressCreatedCommandHelper = addressCreatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }


    public CreateAddressResponse createAddress(CreateAddressCommand command){
        AddressCreatedEvent addressCreatedEvent = addressCreatedCommandHelper.persistIntelInfo(command);
        log.info("Address is created with id: {}", addressCreatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCreateAddress(
                addressCreatedEvent.getIntelInfo(), "Address is created Successfully"
        );
    }
}
