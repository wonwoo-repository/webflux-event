package com.ms.webfluxevent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
@EnableRedisRepositories
public class RedisRepositoryConfig {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public ReactiveRedisConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory(this.redisHost, this.redisPort);
    }

    @Bean
    public ReactiveRedisTemplate<?, ?> reactiveRedisTemplate() {
        return new ReactiveRedisTemplate<>(connectionFactory(), RedisSerializationContext.string());
    }
}
