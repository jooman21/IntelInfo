package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.entity.Address;
import com.custom.eaii.training.valueObjcet.InformedWay;
import com.custom.eaii.training.valueObjcet.IntelDescription;
import com.custom.eaii.training.valueObjcet.IntelStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MakeDecisionCommand {
    private String referenceNumber;
    private IntelStatus intelStatus;
    private IntelDescription intelDescription;
    private InformedWay informedWay;
    private Address address;
    private ZonedDateTime createdAt;
    private String firstName;
    private String lastName;
    private String declineReason;
    private String informantCode;


}
