package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.EmployeeProfileEntity;
import com.custom.eaii.training.entity.EmployeeProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EmployeeProfileDataAccessMapper {
        @Mapping(target = "id", source = "employeeProfile.id.value")
        @Mapping(target = "intelInfoEntity", ignore = true)
        EmployeeProfileEntity employeeProfileToEmployeeProfileEntity(EmployeeProfile employeeProfile);

        @Mapping(target = "employeeProfileId.value", source = "employeeProfileEntity.id")
        EmployeeProfile employeeProfileEntityToEmployeeProfile(EmployeeProfileEntity employeeProfileEntity);
}
