package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.IntelInfoId;
import com.custom.eaii.training.valueObjcet.OperationResult;
import com.custom.eaii.training.valueObjcet.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageCommand {
    private IntelInfoId intelInfoId;
    private String firstName;
    private String lastName;
    private String informantCode;
    private String declineReason;
    private OperationStatus operationStatus;

    private OperationResult operationResult;

    private ZonedDateTime TakePlaceAt;
}
