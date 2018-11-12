package com.ms.webfluxevent.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void save() {

    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
        Order order = new Order("1", 100L, 1, 999L);
    }

    @Test
    public void deleteById() {
    }
}