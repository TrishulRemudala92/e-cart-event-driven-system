package com.ecart.payment.service;

import com.ecart.payment.dto.PaymentDTO;
import com.ecart.payment.entity.Payment;
import com.ecart.payment.entity.PaymentStatus;
import lombok.RequiredArgsConstructor;
import com.ecart.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment createPayment(PaymentDTO dto) {

        Payment payment = Payment.builder()
                .orderId(dto.getOrderId())
                .amount(dto.getAmount())
                .paymentMethod(dto.getPaymentMethod())
                .status(PaymentStatus.SUCCESS)   // for now assume success
                .paymentDate(LocalDateTime.now())
                .build();

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

}


