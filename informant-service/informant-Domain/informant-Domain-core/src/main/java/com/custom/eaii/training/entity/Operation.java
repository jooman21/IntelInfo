package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.OperationId;
import com.custom.eaii.training.valueObjcet.OperationResult;
import com.custom.eaii.training.valueObjcet.OperationStatus;

import java.time.ZonedDateTime;

public class Operation extends BaseEntity<OperationId> {

private OperationStatus operationStatus;

private OperationResult operationResult;

private ZonedDateTime takePlaceAt;




    private Operation(Builder builder) {
        super.setId(builder.operationId);
        this.operationStatus = builder.operationStatus;
        this.operationResult = builder.operationResult;
        this.takePlaceAt = builder.takePlaceAt;
    }
// using constructor
    public Operation(OperationId id, OperationStatus operationStatus, OperationResult operationResult) {
        super();
    }

    //
    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public OperationResult getOperationResult() {
        return operationResult;
    }

    public ZonedDateTime getTakePlaceAt() {
        return takePlaceAt;
    }

    public  static Builder builder(){
        return new Builder();
    }
    public static final class Builder{
        private OperationId operationId;

        private OperationStatus operationStatus;
        private OperationResult operationResult;
        private ZonedDateTime takePlaceAt;

        public Builder setOperationId(OperationId operationId) {
            this.operationId = operationId;
            return this;
        }

        public Builder setOperationStatus(OperationStatus operationStatus) {
            this.operationStatus = operationStatus;
            return this;
        }

        public Builder setOperationResult(OperationResult operationResult) {
            this.operationResult = operationResult;
            return this;
        }

        public Builder setTakePlaceAt(ZonedDateTime takePlaceAt) {
            this.takePlaceAt = takePlaceAt;
            return this;
        }

        public Operation build(){
            return new Operation(this);
        }
    }
}

