package com.ms.webfluxevent.order;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ProductStock {
    COMPUTER(100L, 100),
    PHONE(200L, 80),
    BED(300L, 200),
    TELEVISION(400L, 30);

    private final Long productId;
    private final Integer stock;

    ProductStock(Long productId, Integer stock) {
        this.productId = productId;
        this.stock = stock;
    }

    public static ProductStock get(Long productId) {
         return Arrays.stream(values())
                 .filter(productStock -> productStock.productId.equals(productId))
                 .findFirst()
                 .orElseThrow(NotFoundProductException::new);
    }
}
