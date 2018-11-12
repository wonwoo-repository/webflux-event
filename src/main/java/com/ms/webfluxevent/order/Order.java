package com.ms.webfluxevent.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private String id;
    private Long productId;
    private Integer productCount;
    private Long userId;
    private LocalDateTime orderTime;

    public Order() {
        initializeOrderTime();
    }

    public Order(Long productId, Integer productCount, Long userId) {
        this.productId = productId;
        this.productCount = productCount;
        this.userId = userId;
        initializeOrderTime();
    }

    public void initializeOrderTime() {
        this.orderTime = LocalDateTime.now();
    }
}
