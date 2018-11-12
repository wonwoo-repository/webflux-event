package com.ms.webfluxevent.order;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final ReactiveRedisTemplate redisTemplate;

    public OrderService(ReactiveRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /* TODO
     * 1. 재고가 있는지 확인한다.
     * 2. 재고랑 구매 개수랑 비교한다.
     * 3. 이벤트 중 이미 구매한 이력이 있는지 확인한다.
     * 4. 저장한다.
     * */
    public Mono<Order> orderProduct(Order order) {
        return null;
    }

    public Flux<Order> findAll() {
        return null;
    }

    public Mono<Order> findById(String id) {
        return null;
    }

    public Mono<Void> deleteById(String id) {
        return null;
    }

}
