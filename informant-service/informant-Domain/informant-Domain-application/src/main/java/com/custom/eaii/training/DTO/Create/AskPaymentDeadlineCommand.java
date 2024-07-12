package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.IntelInfoId;
import com.custom.eaii.training.valueObjcet.PaymentDecision;
import com.custom.eaii.training.valueObjcet.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AskPaymentDeadlineCommand {
    private IntelInfoId intelInfoId;
    private String informantCode;
    private UUID id;
    private PaymentStatus paymentStatus;
    private PaymentDecision paymentDecision;
    private BigDecimal allowedPayment;
    private ZonedDateTime approvedAt;
}
