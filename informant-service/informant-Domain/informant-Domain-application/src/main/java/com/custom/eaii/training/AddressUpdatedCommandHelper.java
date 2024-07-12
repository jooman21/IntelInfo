package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateAddressCommand;
import com.custom.eaii.training.entity.Address;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.AddressUpdatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddressUpdatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public AddressUpdatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public AddressUpdatedEvent persistIntelInfo(CreateAddressCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapAddressCommandToIntelInfo(command);
        Address newAddress = intelInfo.getAddress();
        AddressUpdatedEvent addressUpdatedEvent = intelInfoDomainService.validateAndUpdateAddress(intelInfo,newAddress);
        saveUpdatedAddress(addressUpdatedEvent.getIntelInfo());
        log.info("Contact is created  with id:{}", addressUpdatedEvent.getIntelInfo().getId().getValue());
        return addressUpdatedEvent;
    }

    private void saveUpdatedAddress(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save updated Address");
            throw new IntelInfoDomainException("Could not save  Updated Address");
        }
        log.info("Updated Address is saved with id: {}",
                result.getId().getValue());

    }
}
