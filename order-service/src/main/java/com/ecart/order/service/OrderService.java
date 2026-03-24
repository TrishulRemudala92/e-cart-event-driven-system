package com.ecart.order.service;

import com.ecart.order.dto.OrderRequest;
import com.ecart.order.dto.OrderResponse;
import com.ecart.order.events.OrderCreatedEvent;
import com.ecart.order.kafka.OrderEventProducer;
import com.ecart.order.model.Order;
import com.ecart.order.model.OrderStatus;
import com.ecart.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .status(OrderStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        // Publish OrderCreated event to Kafka
        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .occurredAt(Instant.now())
                .orderNumber(order.getOrderNumber())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .build();

        try {
            orderEventProducer.publishOrderCreated(event);
        } catch (Exception e) {
            System.out.println("Kafka publish failed: " + e.getMessage());
        }

        return new OrderResponse(
                order.getOrderNumber(),
                order.getStatus().name()
        );
    }

}

