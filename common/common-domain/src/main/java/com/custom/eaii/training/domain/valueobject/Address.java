//package com.custom.eaii.training.domain.valueobject;
//
//
//
//
//
//import java.util.Objects;
//import java.util.UUID;
//
//public class Address {
//    private final UUID id;
//    private final String addressType;
//    private final String street;
//    private final String street2;
//    private final String city;
//
//
//
//    public Address(UUID id, String addressType, String street, String street2, String city,  String postalCode) {
//        this.id = id;
//        this.addressType = addressType;
//        this.street = street;
//        this.street2 = street2;
//        this.city = city;
//
//    }
//
//    public UUID getId() {
//        return this.id;
//    }
//
//    public String getAddressType() {
//        return this.addressType;
//    }
//
//    public String getStreet() {
//        return this.street;
//    }
//
//    public String getStreet2() {
//        return this.street2;
//    }
//
//    public String getCity() {
//        return this.city;
//    }
//
//
//
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Address address)) return false;
//        return Objects.equals(id, address.id) && Objects.equals(addressType, address.addressType) && Objects.equals(street, address.street) && Objects.equals(street2, address.street2) && Objects.equals(city, address.city);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, addressType, street, street2, city);
//    }
//}
