package com.custom.eaii.training.IntelInfo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  UUID id;
    private  String subCity;
    private  String street;
    private  String city;
    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(subCity, that.subCity) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subCity, street, city, intelInfoEntity);
    }
}
