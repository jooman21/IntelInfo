package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.IntelInfoEntity;
import com.custom.eaii.training.entity.IntelInfo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR,uses=
        {OperationDataAccessMapper.class, PaymentDataAccessMapper.class, ComplainDataAccessMapper.class, InformantProfileDataAccessMapper.class, EmployeeProfileDataAccessMapper.class, FinanceOfficerProfileDataAccessMapper.class, AddressDataAccessMapper.class, ContactDataAccessMapper.class})

public interface IntelInfoDataAccessMapper {
        @Mapping(target="id", source = "intelInfo.id.value")

        IntelInfoEntity intelInfoToIntelInfoEntity(IntelInfo intelInfo);

        @Mapping(target = "intelInfoId.value",source = "intelInfoEntity.id")
        IntelInfo intelInfoEntityToIntelInfo(IntelInfoEntity intelInfoEntity);


        @AfterMapping
        default void populateChildItems(@MappingTarget IntelInfoEntity intelInfoEntity) {
                intelInfoEntity.getInformantProfile().setIntelInfoEntity(intelInfoEntity);
                if (intelInfoEntity.getEmployeeProfile() != null) {
                        intelInfoEntity.getEmployeeProfile().setIntelInfoEntity(intelInfoEntity);
                }
                // intelInfoEntity.getEmployeeProfile().setIntelInfoEntity(intelInfoEntity);
                if(intelInfoEntity.getFinanceOfficerProfile() != null){
                        intelInfoEntity.getFinanceOfficerProfile().setIntelInfoEntity(intelInfoEntity);
                }
                if (intelInfoEntity.getComplaint() != null) {
                        intelInfoEntity.getComplaint().setIntelInfoEntity(intelInfoEntity);
                }
                if (intelInfoEntity.getOperation() != null){
                        intelInfoEntity.getOperation().setIntelInfoEntity(intelInfoEntity);}
                if (intelInfoEntity.getPayment() != null) {
                        intelInfoEntity.getPayment().setIntelInfoEntity(intelInfoEntity);
                }
                if(intelInfoEntity.getAddress() != null) {
                        intelInfoEntity.getAddress().setIntelInfoEntity(intelInfoEntity);
                }
                if(intelInfoEntity.getContact() != null) {
                        intelInfoEntity.getContact().setIntelInfoEntity(intelInfoEntity);
                }
        }


}
