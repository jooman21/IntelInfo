package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.ContactEntity;
import com.custom.eaii.training.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ContactDataAccessMapper {
    @Mapping(target = "id", source = "contact.id.value")
    @Mapping(target = "intelInfoEntity", ignore = true)
//    @Mapping(target = "informantProfileEntity", ignore = true)
    ContactEntity contactToContactEntity(Contact contact);

    @Mapping(target = "contactId.value", source = "contactEntity.id")
    Contact contactEntityToContact(ContactEntity contactEntity);


}
