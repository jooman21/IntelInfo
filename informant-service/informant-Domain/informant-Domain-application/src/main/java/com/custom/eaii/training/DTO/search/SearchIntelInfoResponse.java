package com.custom.eaii.training.DTO.search;

import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.valueObjcet.IntelStatus;
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
public class SearchIntelInfoResponse {
    
    private List<IntelInfo> intelInfos;
    private  Optional<IntelInfo> intel_Info;
//

    // Method to search for IntelInfo's by status
    private List<IntelInfo> searchByStatus(IntelStatus status) {
        return intelInfos.stream()
                .filter(intelInfo -> intelInfo.getIntelStatus() == status)
                .collect(Collectors.toList());
    }
    //Method to search for IntelInfo's by id
    // Method to search for IntelInfo's by id
    private Optional<IntelInfo> searchByIntelId(UUID intelInfoId) {
        return intel_Info.filter(intelInfo -> intelInfo.getId().equals(intelInfoId));
    }


}
