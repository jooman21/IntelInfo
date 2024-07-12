package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.ContactId;


public class Contact  extends BaseEntity<ContactId> {

    private  String StreetAddress;
    private  String  PhoneNumber;

    private  String city;
    private  Boolean isActive;



    public Contact(Builder builder) {
        super.setId(builder.contactId);
        this.StreetAddress = builder.StreetAddress;
        this.PhoneNumber = builder.PhoneNumber;
        this.city = builder.city;
        this.isActive = builder.isActive;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getCity() {
        return city;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public static Contact.Builder builder(){
        return new Contact.Builder();
    }

    public static final class Builder{

        private ContactId contactId;
        private  String StreetAddress;
        private  String  PhoneNumber;

        private  String city;
        private  Boolean isActive;


        public Builder setContactId(ContactId contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            StreetAddress = streetAddress;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setIsActive(Boolean active) {
            isActive = active;
            return this;
        }

        public Contact build() {return new Contact(this);}
    }

}
