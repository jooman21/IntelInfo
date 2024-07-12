package com.custom.eaii.training.DTO.Create;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateComplainResponse {
    private UUID intelInfoId;
    private String message;
}
