package com.custom.eaii.training.IntelInfo.entity;

import com.custom.eaii.training.data.entity.AuditableEntity;
import com.custom.eaii.training.valueObjcet.InformedWay;
import com.custom.eaii.training.valueObjcet.IntelDescription;
import com.custom.eaii.training.valueObjcet.IntelStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="intel_infos")
public class IntelInfoEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String referenceNumber;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private InformantProfileEntity informantProfile;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private EmployeeProfileEntity employeeProfile;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private FinanceOfficerProfileEntity financeOfficerProfile;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private OperationEntity operation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private PaymentEntity payment;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private ComplaintEntity complaint;

    @Enumerated(EnumType.STRING)
    private InformedWay informedWay;

    @Enumerated(EnumType.STRING)
    private IntelStatus intelStatus;

    @Enumerated(EnumType.STRING)
    private IntelDescription intelDescription;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private AddressEntity address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="intelInfoEntity")
    private ContactEntity contact;
    private ZonedDateTime createdAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntelInfoEntity that = (IntelInfoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(referenceNumber, that.referenceNumber) && Objects.equals(informantProfile, that.informantProfile) && Objects.equals(employeeProfile, that.employeeProfile) && Objects.equals(financeOfficerProfile, that.financeOfficerProfile) && Objects.equals(operation, that.operation) && Objects.equals(payment, that.payment) && Objects.equals(complaint, that.complaint) && informedWay == that.informedWay && intelStatus == that.intelStatus && intelDescription == that.intelDescription && Objects.equals(address, that.address) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referenceNumber, informantProfile, employeeProfile, financeOfficerProfile, operation, payment, complaint, informedWay, intelStatus, intelDescription, address, createdAt);
    }
}