package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.ComplainDescription;
import com.custom.eaii.training.valueObjcet.ComplainId;
import com.custom.eaii.training.valueObjcet.ComplainStatus;

import java.time.ZonedDateTime;

public class Complaint extends BaseEntity<ComplainId> {

    private ComplainDescription complainDescription;


    private ComplainStatus complainStatus;

    private IntelInfo intelInfo;
    private ZonedDateTime reportedAt;


    public Complaint(Builder builder) {
        super.setId(builder.complainId);
        this.complainDescription = builder.complainDescription;
        this.complainStatus = builder.complainStatus;
        this.intelInfo = builder.intelinfo;
        this.reportedAt = builder.reportedAt;
    }



    // using constructor




    public Complaint(ComplainId id, ComplainStatus complainStatus) {
        super();
    }


    public ComplainDescription getComplainDescription() {
        return complainDescription;
    }



    public ComplainStatus getComplainStatus() {
        return complainStatus;
    }

    public IntelInfo getIntelInfo() {
        return intelInfo;
    }

    public ZonedDateTime getReportedAt() {
        return reportedAt;
    }
    public  static Builder builder(){
        return new Builder();
    }
    public  static final class Builder {
        private ComplainId complainId;






        private ComplainDescription complainDescription;

        private ComplainStatus complainStatus;


        private IntelInfo intelinfo;

        private ZonedDateTime reportedAt;

        public Builder setComplainId(ComplainId complainId) {
            this.complainId = complainId;
            return this;
        }







        public Builder setComplainDescription(ComplainDescription complainDescription) {
            this.complainDescription = complainDescription;
            return  this;
        }

        public Builder setComplainStatus(ComplainStatus complainStatus) {
            this.complainStatus = complainStatus;
            return  this;
        }



        public Builder setReportedAt(ZonedDateTime reportedAt) {
            this.reportedAt = reportedAt;
            return  this;
        }
        public Complaint build(){
            return new Complaint(this);
        }


    }

    }