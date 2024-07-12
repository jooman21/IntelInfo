package com.custom.eaii.training;

import com.custom.eaii.training.DTO.search.SearchPaymentResponse;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import com.custom.eaii.training.valueObjcet.PaymentDecision;
import com.custom.eaii.training.valueObjcet.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class SearchPaymentCommandHandler {
    private final IntelInfoRepository intelInfoRepository;

    public SearchPaymentCommandHandler(IntelInfoRepository intelInfoRepository) {
        this.intelInfoRepository = intelInfoRepository;
    }

    public SearchPaymentResponse searchPayment(){
        return SearchPaymentResponse.builder()
                .payments(intelInfoRepository.findAllPayment())
                .build();
    }

    public SearchPaymentResponse searchByPaymentId(UUID paymentId){
        return SearchPaymentResponse.builder()
                .payment_result(intelInfoRepository.findByPaymentId(paymentId))
                .build();
    }
    public SearchPaymentResponse searchByStatus(PaymentStatus status) {
        return SearchPaymentResponse.builder()
                .payments(intelInfoRepository.findByPaymentStatus(status))
                .build();
    }

    public SearchPaymentResponse searchByDecision(PaymentDecision decision) {
        return SearchPaymentResponse.builder()
                .payment_result(intelInfoRepository.findByPaymentDecision(decision))
                .build();
    }
}
