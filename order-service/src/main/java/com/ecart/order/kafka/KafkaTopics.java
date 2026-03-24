package com.ecart.order.kafka;

public class KafkaTopics {
    private KafkaTopics() {}

    public static final String ORDER_CREATED = "ecart.order.created";
    public static final String PAYMENT_RESULT = "ecart.payment.result";
}
