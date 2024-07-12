package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.*;
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
public class CreatePaymentCommand {
    private UUID id;
    private PaymentStatus paymentStatus;

    private PaymentDecision paymentDecision;

    private BigDecimal itemPrice;

    private BigDecimal allowedPayment;


    private String declinedPaymentReason;

    private ZonedDateTime approvedAt;

    private ZonedDateTime createdAt;
}
