package com.custom.eaii.training.IntelInfo.adapter;

import com.custom.eaii.training.IntelInfo.entity.ComplaintEntity;
import com.custom.eaii.training.IntelInfo.entity.IntelInfoEntity;
import com.custom.eaii.training.IntelInfo.entity.OperationEntity;
import com.custom.eaii.training.IntelInfo.entity.PaymentEntity;
import com.custom.eaii.training.IntelInfo.mapper.ComplainDataAccessMapper;
import com.custom.eaii.training.IntelInfo.mapper.IntelInfoDataAccessMapper;
import com.custom.eaii.training.IntelInfo.mapper.OperationDataAccessMapper;
import com.custom.eaii.training.IntelInfo.mapper.PaymentDataAccessMapper;
import com.custom.eaii.training.IntelInfo.repository.ComplaintJpaRepository;
import com.custom.eaii.training.IntelInfo.repository.IntelInfoJpaRepository;
import com.custom.eaii.training.IntelInfo.repository.OperationJpaRepository;
import com.custom.eaii.training.IntelInfo.repository.PaymentJpaRepository;
import com.custom.eaii.training.entity.Complaint;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.entity.Operation;
import com.custom.eaii.training.entity.Payment;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import com.custom.eaii.training.valueObjcet.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
public class IntelInfoRepositoryImpl implements IntelInfoRepository {
    private final IntelInfoJpaRepository intelInfoJpaRepository;

    private final IntelInfoDataAccessMapper intelInfoDataAccessMapper;

    private final ComplainDataAccessMapper complainDataAccessMapper;

    private final ComplaintJpaRepository complaintJpaRepository;

    private final OperationDataAccessMapper operationDataAccessMapper;

    private final OperationJpaRepository operationJpaRepository;

    private final PaymentJpaRepository paymentJpaRepository;

    private final PaymentDataAccessMapper paymentDataAccessMapper;


    public IntelInfoRepositoryImpl(IntelInfoJpaRepository intelInfoJpaRepository, IntelInfoDataAccessMapper intelInfoDataAccessMapper, ComplainDataAccessMapper complainDataAccessMapper, ComplaintJpaRepository complaintJpaRepository, OperationDataAccessMapper operationDataAccessMapper, OperationJpaRepository operationJpaRepository, PaymentJpaRepository paymentJpaRepository, PaymentDataAccessMapper paymentDataAccessMapper) {
        this.intelInfoJpaRepository = intelInfoJpaRepository;
        this.intelInfoDataAccessMapper = intelInfoDataAccessMapper;
        this.complainDataAccessMapper = complainDataAccessMapper;
        this.complaintJpaRepository = complaintJpaRepository;
        this.operationDataAccessMapper = operationDataAccessMapper;
        this.operationJpaRepository = operationJpaRepository;
        this.paymentJpaRepository = paymentJpaRepository;
        this.paymentDataAccessMapper = paymentDataAccessMapper;
    }


    @Override
    public IntelInfo save(IntelInfo intelInfo) {
        IntelInfoEntity entity = intelInfoDataAccessMapper.intelInfoToIntelInfoEntity(intelInfo);
        return intelInfoDataAccessMapper.intelInfoEntityToIntelInfo(
                intelInfoJpaRepository.save(entity)
        );
    }

    @Override
    public Optional<IntelInfo>findByIntelId (UUID intelInfoId)  {
        return  intelInfoJpaRepository.findById(intelInfoId)
                .map(intelInfoDataAccessMapper::intelInfoEntityToIntelInfo);
    }


    @Override
    public List<IntelInfo> findAllIntelInfo() {
        List<IntelInfoEntity> intelInfos = intelInfoJpaRepository.findAll();
        if (CollectionUtils.isEmpty(intelInfos)) {
            return null;
        }
        return intelInfos.stream()
                .map(intelInfoDataAccessMapper::intelInfoEntityToIntelInfo)
                .collect(Collectors.toList());
    }




    @Override
    public List<IntelInfo> findByIntelStatus(IntelStatus intelStatus) {
        List<IntelInfoEntity> intelInfos = intelInfoJpaRepository.findByIntelStatus(intelStatus);
        if (CollectionUtils.isEmpty(intelInfos)) {
            return null;
        }
        return intelInfos.stream()
                .map(intelInfoDataAccessMapper::intelInfoEntityToIntelInfo)
                .collect(Collectors.toList());
    }

    @Override
    public Complaint save(Complaint complaint) {
        ComplaintEntity entity = complainDataAccessMapper.complaintToComplaintEntity(complaint);
        entity = complaintJpaRepository.save(entity);
        return complainDataAccessMapper.complaintEntityToComplain(entity);

    }

    @Override
    public Optional<Complaint> findByComplainId(UUID complainId) {
        return  complaintJpaRepository.findById(complainId)
                .map(complainDataAccessMapper::complaintEntityToComplain);
    }

    @Override
    public List<Complaint> findAllComplaints() {
        List<ComplaintEntity> complaints = complaintJpaRepository.findAll();
        if (CollectionUtils.isEmpty(complaints)) {
            return null;
        }
        return complaints.stream()
                .map(complainDataAccessMapper::complaintEntityToComplain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Complaint> findByComplaintStatus(ComplainStatus status) {
        List<ComplaintEntity> complaints = complaintJpaRepository.findByComplainStatus(status);
        if (CollectionUtils.isEmpty(complaints)) {
            return null;
        }
        return complaints.stream()
                .map(complainDataAccessMapper::complaintEntityToComplain)
                .collect(Collectors.toList());
    }

    @Override
    public Operation save(Operation operation) {
        OperationEntity entity = operationDataAccessMapper.operationToOperationEntity(operation);
        entity = operationJpaRepository.save(entity);
        return operationDataAccessMapper.operationEntityToOperation(entity);
    }

    @Override
    public Optional<Operation> findByOperationId(UUID operationId) {
        return  operationJpaRepository.findById(operationId)
                .map(operationDataAccessMapper::operationEntityToOperation);
    }

    @Override
    public List<Operation> findAllOperation() {
        List<OperationEntity> operations = operationJpaRepository.findAll();
        if (CollectionUtils.isEmpty(operations)) {
            return null;
        }
        return operations.stream()
                .map(operationDataAccessMapper::operationEntityToOperation)
                .collect(Collectors.toList());
    }

    @Override
    public List<Operation> findByOperationStatus(OperationStatus status) {
        List<OperationEntity> operations = operationJpaRepository.findByOperationStatus(status);
        if (CollectionUtils.isEmpty(operations)) {
            return null;
        }
        return operations.stream()
                .map(operationDataAccessMapper::operationEntityToOperation)
                .collect(Collectors.toList());
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = paymentDataAccessMapper.paymentToPaymentEntity(payment);
        entity = paymentJpaRepository.save(entity);
        return paymentDataAccessMapper.paymentEntityToPayment(entity);
    }

    @Override
    public Optional<Payment> findByPaymentId(UUID paymentId) {
        return  paymentJpaRepository.findById(paymentId)
                .map(paymentDataAccessMapper::paymentEntityToPayment);
    }

    @Override
    public List<Payment> findAllPayment() {
        List<PaymentEntity> payments = paymentJpaRepository.findAll();
        if (CollectionUtils.isEmpty(payments)) {
            return null;
        }
        return payments.stream()
                .map(paymentDataAccessMapper::paymentEntityToPayment)
                .collect(Collectors.toList());
    }

    @Override
    public List<Payment> findByPaymentStatus(PaymentStatus status) {
        return null;
    }

//    @Override
//    public List<Payment> findByPaymentStatus(PaymentStatus status) {
//        List<PaymentEntity> payments = paymentJpaRepository.findByPaymentStatus(status);
//        if (CollectionUtils.isEmpty(payments)) {
//            return null;
//        }
//        return payments.stream()
//                .map(paymentDataAccessMapper::paymentEntityToPayment)
//                .collect(Collectors.toList());
//    }

    @Override
    public Optional<Payment> findByPaymentDecision(PaymentDecision decision) {
        return Optional.empty();
    }
}


