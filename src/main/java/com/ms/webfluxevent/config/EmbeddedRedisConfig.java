package com.ms.webfluxevent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.util.Objects.nonNull;

@Component
public class EmbeddedRedisConfig {
    @Value("${spring.redis.port}")
    private int redisPort;
    private RedisServer redisServer;

    @PostConstruct
    public void redisServer() {
        this.redisServer = new RedisServer(this.redisPort);
        this.redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        if (nonNull(this.redisServer)) {
            this.redisServer.stop();
        }
    }
}
