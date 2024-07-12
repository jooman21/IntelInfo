package com.custom.eaii.training.ports.output.repository;

import com.custom.eaii.training.entity.Complaint;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.entity.Operation;
import com.custom.eaii.training.entity.Payment;
import com.custom.eaii.training.valueObjcet.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IntelInfoRepository {

    IntelInfo save(IntelInfo intelInfo);


    Optional<IntelInfo> findByIntelId(UUID intelInfoId);

    List<IntelInfo> findAllIntelInfo();


    List<IntelInfo> findByIntelStatus(IntelStatus intelStatus);

    Complaint save(Complaint complaint);
    Optional<Complaint> findByComplainId(UUID complainId);

    List<Complaint> findAllComplaints();
    List<Complaint> findByComplaintStatus(ComplainStatus status);


    Operation save(Operation operation);
    Optional<Operation> findByOperationId(UUID operationId);

    List<Operation> findAllOperation();
    List<Operation> findByOperationStatus(OperationStatus status);



    Payment save(Payment payment);
    Optional<Payment> findByPaymentId(UUID paymentId);

    List<Payment> findAllPayment();
    List<Payment> findByPaymentStatus(PaymentStatus status);

    Optional<Payment> findByPaymentDecision(PaymentDecision decision);

}
