package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.OperationEntity;
import com.custom.eaii.training.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OperationDataAccessMapper {
    @Mapping(target = "id", source = "operation.id.value")
    @Mapping(target = "intelInfoEntity", ignore = true)
    OperationEntity operationToOperationEntity(Operation operation);

    @Mapping(target = "operationId.value", source = "operationEntity.id")
    Operation operationEntityToOperation(OperationEntity operationEntity);
}
