package com.custom.eaii.training.IntelInfo.repository;


import com.custom.eaii.training.IntelInfo.entity.IntelInfoEntity;
import com.custom.eaii.training.valueObjcet.IntelStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IntelInfoJpaRepository extends JpaRepository<IntelInfoEntity, UUID> {

    Optional<IntelInfoEntity>findById(UUID id);
    List<IntelInfoEntity> findByIntelStatus(IntelStatus intelStatus);
}
  