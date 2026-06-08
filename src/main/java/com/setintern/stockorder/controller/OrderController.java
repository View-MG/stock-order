package com.setintern.stockorder.controller;

import com.setintern.stockorder.dto.CreateOrder;
import com.setintern.stockorder.dto.UpdateOrder;
import com.setintern.stockorder.entity.Order;
import com.setintern.stockorder.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable String id){
        return orderService.getOrder(id);
    }

    @PostMapping("/order")
    public String createOrder(@Valid @RequestBody CreateOrder req){
        return orderService.createOrder(req);
    }

    @PatchMapping("/order/{id}")
    public String updateOrder(@PathVariable String id, @Valid @RequestBody UpdateOrder req){
        return orderService.updateOrder(id, req);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable String id){
        return orderService.deleteOrder(id);
    }
}
