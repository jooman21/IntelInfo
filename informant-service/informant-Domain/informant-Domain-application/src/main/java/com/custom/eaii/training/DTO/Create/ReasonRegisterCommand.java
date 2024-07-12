package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.IntelInfoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReasonRegisterCommand {
    private  IntelInfoId IntelInfoId;
    private String firstName;
    private String lastName;
    private String informantCode;
    private String declineReason;
}
