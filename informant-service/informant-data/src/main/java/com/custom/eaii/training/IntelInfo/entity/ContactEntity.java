package com.custom.eaii.training.IntelInfo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  UUID id;
    private  String StreetAddress;
    private  String  PhoneNumber;

    private  String city;
    private  Boolean isActive;


    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

   /* @OneToOne
    @JoinColumn(name = "informant_id")
    private InformantProfileEntity informantProfileEntity;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactEntity that = (ContactEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(StreetAddress, that.StreetAddress) && Objects.equals(PhoneNumber, that.PhoneNumber) && Objects.equals(city, that.city) && Objects.equals(isActive, that.isActive) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, StreetAddress, PhoneNumber, city, isActive, intelInfoEntity);
    }
}
