package com.custom.eaii.training.DTO.Create;

import lombok.*;

import java.util.UUID;

@Getter

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeclineIntelInfoResponse {
    private UUID intelInfoId;
    private String message;
}
