package com.ecart.order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {
    private String productId;
    private int quantity;
    private BigDecimal price;

}
