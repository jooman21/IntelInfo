package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.FinanceOfficerProfileEntity;
import com.custom.eaii.training.entity.FinanceOfficerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface FinanceOfficerProfileDataAccessMapper {
    @Mapping(target = "id", source = "financeOfficerProfile.id.value")
    @Mapping(target = "intelInfoEntity", ignore = true)
    FinanceOfficerProfileEntity  financeOfficerProfileToFinanceOfficerProfileEntity(FinanceOfficerProfile financeOfficerProfile);

    @Mapping(target = "financeOfficerId.value", source = "financeOfficerProfileEntity.id")
    FinanceOfficerProfile FinanceOfficerProfileEntityTofinanceOfficerProfile(FinanceOfficerProfileEntity financeOfficerProfileEntity);
}
