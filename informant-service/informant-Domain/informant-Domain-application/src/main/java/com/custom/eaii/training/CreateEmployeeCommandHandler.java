package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CreateEmployeeCommand;
import com.custom.eaii.training.DTO.Create.CreateEmployeeResponse;
import com.custom.eaii.training.event.EmployeeCreatedEvent;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateEmployeeCommandHandler {
    private final IntelInfoDataMapper intelInfoDataMapper;
     private final EmployeeProfileCreatedCommandHelper employeeProfileCreatedCommandHelper;

    public CreateEmployeeCommandHandler(IntelInfoDataMapper intelInfoDataMapper, EmployeeProfileCreatedCommandHelper employeeProfileCreatedCommandHelper) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.employeeProfileCreatedCommandHelper = employeeProfileCreatedCommandHelper;
    }

    public CreateEmployeeResponse createEmployee(CreateEmployeeCommand command){
        EmployeeCreatedEvent employeeCreatedEvent = employeeProfileCreatedCommandHelper.persistIntelInfo(command);
        log.info("Employee Profile is created   with id: {}", employeeCreatedEvent.getIntelInfo().getId().getValue());
        return  intelInfoDataMapper.intelInfoToCreateEmployee(
                employeeCreatedEvent.getIntelInfo(), "Employee Profile is created created Successfully"
        );
    }
}
