package com.custom.eaii.training.DTO.search;


import com.custom.eaii.training.entity.Operation;
import com.custom.eaii.training.valueObjcet.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchOperationResponse {
    private List<Operation> operations;
    private Optional<Operation> operation_result;
//

    // Method to search for Operation by status
    private List<Operation> searchByStatus(OperationStatus status) {
        return operations.stream()
                .filter(intelInfo -> intelInfo.getOperationStatus() == status)
                .collect(Collectors.toList());
    }

    // Method to search for Operation's by id
    private Optional<Operation> searchByOperationId(UUID operationId) {
        return operation_result.filter( operation ->  operation.getId().equals(operationId));
    }
}
