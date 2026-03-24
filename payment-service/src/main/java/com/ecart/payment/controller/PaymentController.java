package com.ecart.payment.controller;

import com.ecart.payment.dto.PaymentDTO;
import com.ecart.payment.entity.Payment;
import com.ecart.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@RequestBody PaymentDTO dto) {

        return paymentService.createPayment(dto);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

}

