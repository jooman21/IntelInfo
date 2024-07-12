package com.custom.eaii.training.IntelInfo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="finance_officer_profile")
public class FinanceOfficerProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String paymentDeclineReason;

    private ZonedDateTime declinedAt;
    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceOfficerProfileEntity that = (FinanceOfficerProfileEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(employeeId, that.employeeId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(paymentDeclineReason, that.paymentDeclineReason) && Objects.equals(declinedAt, that.declinedAt) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, firstName, lastName, paymentDeclineReason, declinedAt, intelInfoEntity);
    }
}