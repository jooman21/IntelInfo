package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateAddressCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.AddressCreatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddressCreatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public AddressCreatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public AddressCreatedEvent persistIntelInfo(CreateAddressCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapAddressCommandToIntelInfo(command);
        AddressCreatedEvent addressCreatedEvent = intelInfoDomainService.validateAndCreateAddress(intelInfo);
        saveCreatedAddress(addressCreatedEvent.getIntelInfo());
        log.info("Address is created  with id:{}", addressCreatedEvent.getIntelInfo().getId().getValue());
        return addressCreatedEvent;
    }

    private void saveCreatedAddress(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Address");
            throw new IntelInfoDomainException("Could not save  Address");
        }
        log.info("Address is saved with id: {}",
                result.getId().getValue());

    }
}
