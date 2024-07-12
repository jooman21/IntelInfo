package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateAddressCommand;
import com.custom.eaii.training.DTO.Create.CreateAddressResponse;
import com.custom.eaii.training.event.AddressUpdatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateAddressCommandHandler {

    private final AddressUpdatedCommandHelper addressUpdatedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public UpdateAddressCommandHandler(AddressUpdatedCommandHelper addressUpdatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.addressUpdatedCommandHelper = addressUpdatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CreateAddressResponse updateAddress(CreateAddressCommand command){
        AddressUpdatedEvent addressUpdatedEvent = addressUpdatedCommandHelper.persistIntelInfo(command);
        log.info("Address is updated with id: {}", addressUpdatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCreateAddress(
                addressUpdatedEvent.getIntelInfo(), "Address is updated Successfully"
        );
    }
}
