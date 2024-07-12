package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Payment extends BaseEntity<PaymentId> {
    private PaymentStatus  paymentStatus;

    private PaymentDecision paymentDecision;

    private BigDecimal itemPrice;

    private BigDecimal allowedPayment;


    private byte[] paymentReceipt;

    private ZonedDateTime approvedAt;
    private ZonedDateTime createdAt;


    public Payment(Builder builder) {
        super.setId(builder.paymentId);
        this.paymentStatus = builder.paymentStatus;
        this.paymentDecision = builder.paymentDecision;
        this.itemPrice = builder.itemPrice;
        this.allowedPayment = builder.allowedPayment;
        this.paymentReceipt = builder.paymentReceipt;
        this.createdAt = builder.createdAt;
        this.approvedAt = builder.approvedAt;
    }


    public Payment(PaymentId id,PaymentStatus paymentStatus ) {
       super();
    }

    public Payment(PaymentId id, BigDecimal allowedPayment) {
        super();
    }

    public Payment(PaymentId id, PaymentDecision paymentDecision) {
        super();
    }

    public Payment(PaymentId id,byte [] paymentReceipt) {
        super();
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public PaymentDecision getPaymentDecision() {
        return paymentDecision;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public BigDecimal getAllowedPayment() {
        return allowedPayment;
    }


    public byte[] getPaymentReceipt() {
        return paymentReceipt;
    }

    public ZonedDateTime getApprovedAt() {
        return approvedAt;
    }
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }



    public  static Builder builder(){
        return new Builder();
    }
    public static final class Builder{
        private PaymentId paymentId;
        private PaymentStatus paymentStatus;
        private PaymentDecision paymentDecision;

        private BigDecimal itemPrice;

        private BigDecimal allowedPayment;


        private byte[] paymentReceipt;
        private ZonedDateTime approvedAt;

        private ZonedDateTime createdAt;

        public Builder setPaymentId(PaymentId paymentId) {
            this.paymentId = paymentId;
            return this;
        }



        public Builder setPaymentStatus(PaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder setPaymentDecision(PaymentDecision paymentDecision) {
            this.paymentDecision = paymentDecision;
            return this;
        }

        public Builder setItemPrice(BigDecimal itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        public Builder setAllowedPayment(BigDecimal allowedPayment) {
            this.allowedPayment = allowedPayment;
            return this;
        }
        public Builder setPaymentReceipt(byte[] paymentReceipt) {
            this.paymentReceipt = paymentReceipt;
            return this;
        }


        public Builder setApprovedAt(ZonedDateTime approvedAt) {
            this.approvedAt = approvedAt;
            return this;
        }
        public Builder setCreatedAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Payment build(){
            return new Payment(this);
        }
    }
}
