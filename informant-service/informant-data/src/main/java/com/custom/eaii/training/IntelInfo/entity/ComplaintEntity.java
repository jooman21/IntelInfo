package com.custom.eaii.training.IntelInfo.entity;

import com.custom.eaii.training.valueObjcet.ComplainDescription;
import com.custom.eaii.training.valueObjcet.ComplainStatus;
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
@Table(name="complain")

public class ComplaintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ComplainDescription complainDescription;

    @Enumerated(EnumType.STRING)
    private ComplainStatus complainStatus;



    private ZonedDateTime reportedAt;

    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplaintEntity that = (ComplaintEntity) o;
        return Objects.equals(id, that.id) && complainDescription == that.complainDescription && complainStatus == that.complainStatus && Objects.equals(reportedAt, that.reportedAt) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, complainDescription, complainStatus, reportedAt, intelInfoEntity);
    }
}
