package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.InformantProfileId;

import java.util.UUID;

public class InformantProfile extends BaseEntity<InformantProfileId> {
    private String informantCode;
    private String firstName;
    private String lastName;

    private  String bankName;
    private  String accountNumber;






   private InformantProfile(Builder builder){
       super.setId(builder.informantProfileId);
       informantCode = builder.informantCode;
       firstName = builder.firstName;
       lastName = builder.lastName;
       accountNumber= builder.accountNumber;
       bankName= builder.bankName;

   }

    void generateInformantCode() {
        setId(new InformantProfileId(UUID.randomUUID()));
        // Generate a unique code for the informant profile
        informantCode = UUID.randomUUID().toString();
    }

    public String getInformantCode() {
        return informantCode;
    }

    public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public static Builder builder(){
      return new Builder();
   }

//

    public static final class Builder{
         private InformantProfileId informantProfileId;
         private String informantCode;
         private String firstName;
         private String lastName;

        private  String bankName;
        private  String accountNumber;






       private Builder() {
       }
        public Builder setInformantProfileId(InformantProfileId informantProfileId) {
            this.informantProfileId = informantProfileId;
            return this;
        }

       public Builder setInformantCode(String informantCode) {
           this.informantCode = informantCode;
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

        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }





         public InformantProfile build(){
            return new InformantProfile(this);
         }


   }
}

