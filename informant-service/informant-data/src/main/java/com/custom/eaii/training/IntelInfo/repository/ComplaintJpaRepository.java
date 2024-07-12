package com.custom.eaii.training.IntelInfo.repository;

import com.custom.eaii.training.IntelInfo.entity.ComplaintEntity;
import com.custom.eaii.training.valueObjcet.ComplainStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComplaintJpaRepository extends JpaRepository<ComplaintEntity, UUID> {
    Optional<ComplaintEntity> findById(UUID id);
    List<ComplaintEntity> findByComplainStatus(ComplainStatus status);
}
