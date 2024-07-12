package com.custom.eaii.training.DTO.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendUnsuccessfulOperationResultMessageResponse {
    private UUID intelInfoId;
    private String message;
}
