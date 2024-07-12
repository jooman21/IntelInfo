package com.custom.eaii.training.IntelInfo.repository;

import com.custom.eaii.training.IntelInfo.entity.PaymentEntity;
import com.custom.eaii.training.entity.Payment;
import com.custom.eaii.training.valueObjcet.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findById(UUID id);

    List<Payment> findByPaymentStatus(PaymentStatus status);
}
