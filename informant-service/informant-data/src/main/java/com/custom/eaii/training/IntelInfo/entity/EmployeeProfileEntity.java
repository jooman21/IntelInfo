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
@Table(name="employee_profile")
public class EmployeeProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String companyId;
    private String firstName;
    private String lastName;

    private String declineReason;


    private ZonedDateTime declinedAt;

    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProfileEntity that = (EmployeeProfileEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(companyId, that.companyId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(declineReason, that.declineReason) && Objects.equals(declinedAt, that.declinedAt) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, firstName, lastName, declineReason, declinedAt, intelInfoEntity);
    }
}