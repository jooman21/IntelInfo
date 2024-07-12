package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.AddressEntity;
import com.custom.eaii.training.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressDataAccessMapper {
    @Mapping(target = "id", source = "address.id.value")
    @Mapping(target = "intelInfoEntity", ignore = true) // Add this mapping
    AddressEntity addressToAddressEntity(Address address);
    @Mapping(target = "addressId.value", source = "addressEntity.id")
    Address addressEntityToAddress(AddressEntity addressEntity);
}







