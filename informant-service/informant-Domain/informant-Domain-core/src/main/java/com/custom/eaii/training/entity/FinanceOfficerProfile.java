package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.FinanceOfficerId;

import java.time.ZonedDateTime;

public class FinanceOfficerProfile extends BaseEntity<FinanceOfficerId> {

    private  String employeeId;
    private String firstName;
    private String lastName;

    private String paymentDeclineReason;

    private ZonedDateTime declinedAt;

    private FinanceOfficerProfile(Builder builder){
        super.setId(builder.financeOfficerId);
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.paymentDeclineReason = builder.paymentDeclineReason;

        this.declinedAt = builder.declinedAt;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPaymentDeclineReason() {
        return paymentDeclineReason;
    }



    public ZonedDateTime getDeclinedAt() {
        return declinedAt;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static final class Builder{

        private FinanceOfficerId financeOfficerId;

        private  String employeeId;
        private String firstName;
        private String lastName;

        private String paymentDeclineReason;

        private ZonedDateTime declinedAt;

        public Builder setFinanceOfficerId(FinanceOfficerId financeOfficerId) {
            this.financeOfficerId = financeOfficerId;
            return this;
        }

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;

        }

        public Builder setPaymentDeclineReason(String paymentDeclineReason) {
            this.paymentDeclineReason = paymentDeclineReason;
            return this;
        }



        public Builder setDeclinedAt(ZonedDateTime declinedAt) {
            this.declinedAt = declinedAt;
            return this;
        }
        public FinanceOfficerProfile build() {
            return new FinanceOfficerProfile(this);
        }
    }
}
