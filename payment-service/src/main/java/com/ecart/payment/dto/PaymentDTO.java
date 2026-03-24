package com.ecart.payment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDTO {

    private String orderId;
    private BigDecimal amount;
    private String paymentMethod;

}
