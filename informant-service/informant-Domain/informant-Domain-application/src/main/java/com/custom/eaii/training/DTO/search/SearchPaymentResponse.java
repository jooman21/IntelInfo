package com.custom.eaii.training.DTO.search;

import com.custom.eaii.training.entity.Payment;
import com.custom.eaii.training.valueObjcet.PaymentDecision;
import com.custom.eaii.training.valueObjcet.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchPaymentResponse {
    private List<Payment> payments;
    private Optional<Payment> payment_result;
//

    // Method to search for complain  by status
    private List<Payment> searchByStatus(PaymentStatus status) {
        return payments.stream()
                .filter(payment -> payment.getPaymentStatus() == status)
                .collect(Collectors.toList());
    }

    private List<Payment> searchByPaymentDecision(PaymentDecision decision) {
        return payments.stream()
                .filter(payment -> payment.getPaymentDecision() == decision)
                .collect(Collectors.toList());
    }

    // Method to search for complaint's by id
    private Optional<Payment> searchByPaymentId(UUID paymentId) {
        return payment_result.filter(payment -> payment.getId().equals(paymentId));
    }

}
