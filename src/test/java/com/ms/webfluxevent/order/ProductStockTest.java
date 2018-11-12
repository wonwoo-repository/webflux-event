package com.ms.webfluxevent.order;

import org.junit.Test;

import static com.ms.webfluxevent.order.ProductStock.COMPUTER;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductStockTest {
    @Test
    public void 텔레비전_조회() {
        ProductStock productStock = ProductStock.get(100L);
        assertThat(productStock).isEqualTo(COMPUTER);
    }

    @Test(expected = NotFoundProductException.class)
    public void 없는_상품_조회() {
        ProductStock productStock = ProductStock.get(999L);
        assertThat(productStock).isEqualTo(COMPUTER);
    }
}