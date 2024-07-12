package com.custom.eaii.training.IntelInfo.mapper;

import com.custom.eaii.training.IntelInfo.entity.PaymentEntity;
import com.custom.eaii.training.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR
        )
public interface PaymentDataAccessMapper {
    @Mapping(target="id",source = "payment.id.value")
    @Mapping(target = "intelInfoEntity",ignore = true)
    PaymentEntity paymentToPaymentEntity(Payment payment);

    @Mapping(target = "paymentId.value",source = "paymentEntity.id")
    Payment paymentEntityToPayment(PaymentEntity paymentEntity);
}

