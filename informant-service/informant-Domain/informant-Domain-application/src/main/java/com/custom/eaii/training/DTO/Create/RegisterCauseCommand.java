package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.IntelInfoId;
import com.custom.eaii.training.valueObjcet.PaymentDecision;
import com.custom.eaii.training.valueObjcet.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCauseCommand {
    private IntelInfoId intelInfoId;
    private String informantCode;
    private PaymentStatus paymentStatus;
    private PaymentDecision paymentDecision;
    private String firstName;
    private String lastName;
    private String paymentDeclineReason;
    private ZonedDateTime declinedAt;
}
