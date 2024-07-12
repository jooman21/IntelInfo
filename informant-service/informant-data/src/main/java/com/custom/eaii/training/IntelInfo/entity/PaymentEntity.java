package com.custom.eaii.training.IntelInfo.entity;

import com.custom.eaii.training.valueObjcet.PaymentDecision;
import com.custom.eaii.training.valueObjcet.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private PaymentStatus  paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentDecision paymentDecision;


    private BigDecimal itemPrice;


    private BigDecimal allowedPayment;


    private byte[] paymentReceipt;

    private ZonedDateTime approvedAt;
    private ZonedDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id) && paymentStatus == that.paymentStatus && paymentDecision == that.paymentDecision && Objects.equals(itemPrice, that.itemPrice) && Objects.equals(allowedPayment, that.allowedPayment) && Arrays.equals(paymentReceipt, that.paymentReceipt) && Objects.equals(approvedAt, that.approvedAt) && Objects.equals(createdAt, that.createdAt) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, paymentStatus, paymentDecision, itemPrice, allowedPayment, approvedAt, createdAt, intelInfoEntity);
        result = 31 * result + Arrays.hashCode(paymentReceipt);
        return result;
    }
}

