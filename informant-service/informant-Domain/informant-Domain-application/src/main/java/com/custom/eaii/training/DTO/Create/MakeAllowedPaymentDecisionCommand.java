package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.IntelInfoId;
import com.custom.eaii.training.valueObjcet.PaymentDecision;
import com.custom.eaii.training.valueObjcet.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakeAllowedPaymentDecisionCommand {
    private IntelInfoId intelInfoId;
    private String informantCode;
    private UUID id;
    private PaymentStatus paymentStatus;
    private PaymentDecision paymentDecision;
    private BigDecimal allowedPayment;
    private ZonedDateTime createdAt;
    private ZonedDateTime approvedAt;
}
