package com.ecart.order.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResultEvent {

    private String orderNumber;        // must match order-service orderNumber
    private String paymentId;          // transaction id from payment-service
    private PaymentStatus status;      // SUCCESS / FAILED
    private String reason;             // optional: why failed
    private Instant processedAt;       // when payment processed
}
