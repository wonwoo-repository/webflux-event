package com.ms.webfluxevent.order;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Repository
public class OrderRepository {
    private final ReactiveRedisTemplate<String, Order> redisTemplate;

    private final ObjectMapper objectMapper;

    public OrderRepository(ReactiveRedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public Mono<Boolean> save(Order order) {
        String id = UUID.randomUUID().toString();
        return this.redisTemplate.opsForHash()
                .putAll(order.getId(), toMap(order));
    }

    public Flux<Order> findAll() {
        return null;
    }

    public Mono<Order> findById(String id) {
        /*return this.redisTemplate.opsForHash()
                .entries(id)
                .then(entries -> entries.)*/
        return null;
    }

    public Mono<Void> deleteById(String id) {
        return null;
    }

    private Map<?, ?> toMap(Object obj) {
        return this.objectMapper.convertValue(obj, new TypeReference<Map<?, ?>>() {
        });
    }
}
