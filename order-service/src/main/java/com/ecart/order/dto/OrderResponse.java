package com.ecart.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderResponse {
    private String orderNumber;
    private String status;
}


