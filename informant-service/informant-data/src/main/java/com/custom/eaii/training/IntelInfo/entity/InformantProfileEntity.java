package com.custom.eaii.training.IntelInfo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "informant")
public class InformantProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String informantCode;
    private String firstName;
    private String lastName;
    private String bankName;
    private String accountNumber;
   /* @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="informantProfileEntity")
    private ContactEntity contact;*/


    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformantProfileEntity that = (InformantProfileEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(informantCode, that.informantCode) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(bankName, that.bankName) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, informantCode, firstName, lastName, bankName, accountNumber, intelInfoEntity);
    }
}