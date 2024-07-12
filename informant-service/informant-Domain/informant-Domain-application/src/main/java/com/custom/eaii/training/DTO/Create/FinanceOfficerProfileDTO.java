package com.custom.eaii.training.DTO.Create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinanceOfficerProfileDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String paymentDeclineReason;
    private ZonedDateTime declinedAt;

}
