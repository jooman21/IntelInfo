package com.custom.eaii.training;

import com.custom.eaii.training.DTO.search.SearchComplaintResponse;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import com.custom.eaii.training.valueObjcet.ComplainStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class SearchComplaintCommandHandler {
    private final IntelInfoRepository intelInfoRepository;

    public SearchComplaintCommandHandler(IntelInfoRepository intelInfoRepository) {
        this.intelInfoRepository = intelInfoRepository;
    }

    public SearchComplaintResponse searchComplaint(){
        return SearchComplaintResponse.builder()
                .complaints(intelInfoRepository.findAllComplaints())
                .build();
    }

    public SearchComplaintResponse searchByComplaintId(UUID complainId){
        return SearchComplaintResponse.builder()
                .complaint_result(intelInfoRepository.findByComplainId(complainId))
                .build();
    }
    public SearchComplaintResponse searchByStatus(ComplainStatus status) {
        return SearchComplaintResponse.builder()
                .complaints(intelInfoRepository.findByComplaintStatus(status))
                .build();
    }
}
