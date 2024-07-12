package com.custom.eaii.training.IntelInfo.repository;

import com.custom.eaii.training.IntelInfo.entity.OperationEntity;
import com.custom.eaii.training.valueObjcet.OperationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OperationJpaRepository extends JpaRepository<OperationEntity, UUID> {
    Optional<OperationEntity> findById(UUID id);

    List<OperationEntity> findByOperationStatus(OperationStatus status);
}
