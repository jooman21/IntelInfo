package com.custom.eaii.training.DTO.Create;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakeDecisionResponse {
    private UUID intelInfoId;
    private String message;
}
