package com.ms.webfluxevent.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.webfluxevent.order.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisRepositoryConfig {

    @Bean
    public ReactiveRedisTemplate<String, Order> reactiveRedisTemplate(ReactiveRedisConnectionFactory connectionFactory,
        ObjectMapper objectMapper) {
        Jackson2JsonRedisSerializer<Order> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Order.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        StringRedisSerializer defaultSerializer = new StringRedisSerializer();
        RedisSerializationContext<String, Order> serializationContext = RedisSerializationContext
            .<String, Order>newSerializationContext(defaultSerializer)
            .hashValue(jackson2JsonRedisSerializer)
            .build();
        return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
    }
}
