package com.custom.eaii.training;

import com.custom.eaii.training.DTO.search.SearchIntelInfoResponse;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import com.custom.eaii.training.valueObjcet.IntelStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Slf4j
@Component
public class SearchIntelInfoCommandHandler {
    private final IntelInfoRepository intelInfoRepository;

    public SearchIntelInfoCommandHandler(IntelInfoRepository intelInfoRepository) {
        this.intelInfoRepository = intelInfoRepository;
    }

    public SearchIntelInfoResponse searchIntelInfo(){
        return SearchIntelInfoResponse.builder()
                .intelInfos(intelInfoRepository.findAllIntelInfo())
                .build();
    }

   public SearchIntelInfoResponse searchByIntelId(UUID intelInfoId){
     return SearchIntelInfoResponse.builder()
         .intel_Info(intelInfoRepository.findByIntelId(intelInfoId))
             .build();
  }
    public SearchIntelInfoResponse searchByStatus(IntelStatus status) {
        return SearchIntelInfoResponse.builder()
                .intelInfos(intelInfoRepository.findByIntelStatus(status))
                .build();
    }
}
