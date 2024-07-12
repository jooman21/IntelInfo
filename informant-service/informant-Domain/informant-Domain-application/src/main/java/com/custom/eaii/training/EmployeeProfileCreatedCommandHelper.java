package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateEmployeeCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.EmployeeCreatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeProfileCreatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public EmployeeProfileCreatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }


    @Transactional
    public EmployeeCreatedEvent persistIntelInfo(CreateEmployeeCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.mapEmployeeCommandToIntelInfo(command);
        EmployeeCreatedEvent employeeCreatedEvent = intelInfoDomainService.validateAndCreateEmployeeProfile(intelInfo);
        saveCreatedEmployee(employeeCreatedEvent.getIntelInfo());
        log.info("Employee is created  with id:{}", employeeCreatedEvent.getIntelInfo().getId().getValue());
        return employeeCreatedEvent;
    }

    private void saveCreatedEmployee(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Employee");
            throw new IntelInfoDomainException("Could not save  Employee");
        }
        log.info("Contact is saved with id: {}",
                result.getId().getValue());

    }
}
