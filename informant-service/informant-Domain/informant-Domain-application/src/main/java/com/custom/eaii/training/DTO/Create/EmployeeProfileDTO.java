package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.entity.IntelInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProfileDTO {
    private String firstName;
    private String lastName;

    private String declineReason;


    private IntelInfo intelInfo;

    private ZonedDateTime declinedAt;
}
