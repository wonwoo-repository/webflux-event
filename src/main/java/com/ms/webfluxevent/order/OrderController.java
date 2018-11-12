package com.ms.webfluxevent.order;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<Boolean> orderProduct(@RequestBody Order order) {
        return this.orderService.orderProduct(order);
    }

    @GetMapping
    public Flux<Order> getOrders() {
        return this.orderService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrder(@PathVariable String id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return this.orderService.deleteById(id);
    }

    @ExceptionHandler({AlreadyOrderException.class})
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
