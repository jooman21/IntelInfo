package com.custom.eaii.training.DTO.search;

import com.custom.eaii.training.entity.Complaint;
import com.custom.eaii.training.valueObjcet.ComplainStatus;
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
public class SearchComplaintResponse {
    private List<Complaint> complaints;
    private Optional<Complaint> complaint_result;
//

    // Method to search for complain  by status
    private List<Complaint> searchByStatus(ComplainStatus status) {
        return complaints.stream()
                .filter(complaint -> complaint.getComplainStatus() == status)
                .collect(Collectors.toList());
    }

    // Method to search for complaint's by id
    private Optional<Complaint> searchByComplaintId(UUID complainId) {
        return complaint_result.filter(complaint -> complaint.getId().equals(complainId));
    }

}
