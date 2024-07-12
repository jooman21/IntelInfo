package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.ComplaintEntity;
import com.custom.eaii.training.entity.Complaint;
import org.mapstruct.*;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ComplainDataAccessMapper {
    @Mapping(target = "id", source = "complaint.id.value")
    @Mapping(target = "intelInfoEntity", ignore = true) // Add this mapping
    ComplaintEntity complaintToComplaintEntity(Complaint complaint);

    @Mapping(target = "complainId.value", source = "complainEntity.id")
    Complaint complaintEntityToComplain(ComplaintEntity complainEntity);

}
