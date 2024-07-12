package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateEmployeeCommand;
import com.custom.eaii.training.DTO.Create.CreateEmployeeResponse;
import com.custom.eaii.training.event.EmployeeProfileUpdatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateEmployeeCommandHandler {
    private final EmployeeUpdatedCommandHelper employeeUpdatedCommandHelper;
    private final IntelInfoDataMapper intelInfoDataMapper;

    public UpdateEmployeeCommandHandler(EmployeeUpdatedCommandHelper employeeUpdatedCommandHelper, IntelInfoDataMapper intelInfoDataMapper) {
        this.employeeUpdatedCommandHelper = employeeUpdatedCommandHelper;
        this.intelInfoDataMapper = intelInfoDataMapper;
    }

    public CreateEmployeeResponse updateEmployeeProfile(CreateEmployeeCommand command){
        EmployeeProfileUpdatedEvent employeeProfileUpdatedEvent = employeeUpdatedCommandHelper.persistIntelInfo(command);
        log.info("Employee Profile is updated with id: {}", employeeProfileUpdatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCreateEmployee(
                employeeProfileUpdatedEvent.getIntelInfo(), "Employee Profile is updated Successfully"
        );
    }
}
