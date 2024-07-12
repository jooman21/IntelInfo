package com.custom.eaii.training;

import com.custom.eaii.training.DTO.search.SearchOperationResponse;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import com.custom.eaii.training.valueObjcet.OperationStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class SearchOperationCommandHandler {
    private final IntelInfoRepository intelInfoRepository;

    public SearchOperationCommandHandler(IntelInfoRepository intelInfoRepository) {
        this.intelInfoRepository = intelInfoRepository;
    }

    public SearchOperationResponse searchOperation(){
        return SearchOperationResponse.builder()
                .operations(intelInfoRepository.findAllOperation())
                .build();
    }

    public SearchOperationResponse searchByOperationId(UUID operationId){
        return SearchOperationResponse.builder()
                .operation_result(intelInfoRepository.findByOperationId(operationId))
                .build();
    }
    public SearchOperationResponse searchByStatus(OperationStatus status) {
        return SearchOperationResponse.builder()
                .operations(intelInfoRepository.findByOperationStatus(status))
                .build();
    }
}
