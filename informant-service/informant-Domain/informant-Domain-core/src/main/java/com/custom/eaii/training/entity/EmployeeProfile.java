package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.EmployeeProfileId;

import java.time.ZonedDateTime;

public class EmployeeProfile extends BaseEntity<EmployeeProfileId> {
    private String companyId;
    private String firstName;
    private String lastName;

    private String declineReason;




    private ZonedDateTime declinedAt;
//



//  super();

    public EmployeeProfile(Builder builder) {
        super.setId(builder.employeeProfileId);
        this.companyId = builder.companyId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.declineReason = builder.declineReason;
        this.declinedAt = builder.declinedAt;
    }

    public EmployeeProfile(String declineReason) {
        super();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public String getCompanyId() {
        return companyId;
    }

    public ZonedDateTime getDeclinedAt() {
        return declinedAt;
    }

    public static EmployeeProfile.Builder builder(){
        return new EmployeeProfile.Builder();
    }

    public static final class Builder{

        private EmployeeProfileId employeeProfileId;

        private String companyId;
        private String firstName;
        private String lastName;

        private String declineReason;





        private ZonedDateTime declinedAt;

        public Builder setEmployeeProfileId(EmployeeProfileId employeeProfileId) {
            this.employeeProfileId = employeeProfileId;
            return this;
        }

        public Builder setCompanyId(String companyId) {
            this.companyId = companyId;
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


        public Builder setDeclineReason(String declineReason){
            this.declineReason = declineReason;
            return  this;
        }



        public Builder setDeclinedAt(ZonedDateTime declinedAt) {
            this.declinedAt = declinedAt;
            return  this;
        }

        public EmployeeProfile build(){
            return new EmployeeProfile(this);
        }
    }
}
