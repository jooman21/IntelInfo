package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.BaseEntity;
import com.custom.eaii.training.valueObjcet.AddressId;

public class Address extends BaseEntity<AddressId> {
    private  String subCity;
    private  String street;
    private  String city;

    public Address(Builder builder){
        super.setId(builder.addressId);
        this.subCity = builder.subCity;
        this.street = builder.street;
        this.city = city;
    }

    public String getSubCity() {
        return subCity;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public static Address.Builder builder(){
        return new Address.Builder();
    }
  public static final  class  Builder {
        private AddressId addressId;
      private  String subCity;
      private  String street;
      private  String city;

      public Builder setAddressId(AddressId addressId) {
          this.addressId = addressId;
          return this;
      }

      public Builder setSubCity(String subCity) {
          this.subCity = subCity;
          return this;
      }

      public Builder setStreet(String street) {
          this.street = street;
          return this;
      }

      public Builder setCity(String city) {
          this.city = city;
          return this;
      }
      public Address build(){
          return new Address(this);}

  }
}
