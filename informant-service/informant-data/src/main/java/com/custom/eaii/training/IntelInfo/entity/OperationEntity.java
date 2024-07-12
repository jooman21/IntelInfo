package com.custom.eaii.training.IntelInfo.entity;

import com.custom.eaii.training.valueObjcet.OperationResult;
import com.custom.eaii.training.valueObjcet.OperationStatus;
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
@Table(name="operation")
public class OperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)

    private OperationStatus operationStatus;

    @Enumerated(EnumType.STRING)

    private OperationResult operationResult;

    private ZonedDateTime takePlaceAt;

    @OneToOne
    @JoinColumn(name = "intel_info_id")
    private IntelInfoEntity intelInfoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationEntity that = (OperationEntity) o;
        return Objects.equals(id, that.id) && operationStatus == that.operationStatus && operationResult == that.operationResult && Objects.equals(takePlaceAt, that.takePlaceAt) && Objects.equals(intelInfoEntity, that.intelInfoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operationStatus, operationResult, takePlaceAt, intelInfoEntity);
    }
}

