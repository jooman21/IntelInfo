package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.InformantProfileEntity;

import com.custom.eaii.training.entity.InformantProfile;
import org.mapstruct.*;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface InformantProfileDataAccessMapper {

    @Mapping(target = "id", source = "informantProfile.id.value")
    @Mapping(target = "intelInfoEntity", ignore = true)
    InformantProfileEntity informantProfileToInformantProfileEntity(InformantProfile informantProfile);

    @Mapping(target = "informantProfileId.value", source = "informantProfileEntity.id")
    InformantProfile informantProfileEntityToInformantProfile(InformantProfileEntity informantProfileEntity);

  /*  @AfterMapping
    default void populateChildItems(@MappingTarget InformantProfileEntity informantProfileEntity) {
        if (informantProfileEntity.getContact() != null) {
            informantProfileEntity.getContact().setInformantProfileEntity(informantProfileEntity);
        }
    }*/
}

