package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateEmployeeCommand;
import com.custom.eaii.training.entity.EmployeeProfile;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.EmployeeProfileUpdatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeUpdatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public EmployeeUpdatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public EmployeeProfileUpdatedEvent persistIntelInfo(CreateEmployeeCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapEmployeeCommandToIntelInfo(command);
        EmployeeProfile newProfile = intelInfo.getEmployeeProfile();
        EmployeeProfileUpdatedEvent employeeProfileUpdatedEvent = intelInfoDomainService.validateAndUpdateEmployeeProfile(intelInfo,newProfile);
        saveUpdatedEmployeeProfile(employeeProfileUpdatedEvent.getIntelInfo());
        log.info("Employee profile is created  with id:{}", employeeProfileUpdatedEvent.getIntelInfo().getId().getValue());
        return employeeProfileUpdatedEvent;
    }

    private void saveUpdatedEmployeeProfile(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save updated Employee Profile");
            throw new IntelInfoDomainException("Could not save  Updated Employee Profile");
        }
        log.info("Updated Employee Profile  is saved with id: {}",
                result.getId().getValue());

    }
}
