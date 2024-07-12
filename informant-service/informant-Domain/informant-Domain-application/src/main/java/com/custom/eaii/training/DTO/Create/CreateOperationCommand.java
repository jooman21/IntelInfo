package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.OperationResult;
import com.custom.eaii.training.valueObjcet.OperationStatus;
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
public class CreateOperationCommand {
    private UUID id;
    private OperationStatus operationStatus;

    private OperationResult operationResult;

    private ZonedDateTime TakePlaceAt;


}
