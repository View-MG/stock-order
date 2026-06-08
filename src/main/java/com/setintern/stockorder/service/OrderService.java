package com.setintern.stockorder.service;

import com.setintern.stockorder.dto.CreateOrder;
import com.setintern.stockorder.entity.Order;
import com.setintern.stockorder.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(String id) {
        Long orderId = Long.parseLong(id);

        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");

    }


    public String createOrder(CreateOrder req){
        Order order = new Order(req.getSymbol(), req.getPrice(), req.getVol());
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
        return "Order created successfully";
    }

    public String updateOrder(String id, CreateOrder req){
        if (req.getSymbol().isBlank()) throw new IllegalArgumentException("symbol is required");
        if (req.getPrice() <= 0) throw new IllegalArgumentException("price must be greater than 0");
        if (req.getVol() <= 0) throw new IllegalArgumentException("vol must be greater than 0");

        Order order = getOrder(id);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
        return "Order created successfully";
    }

    public  String deleteOrder(String id){
        Long orderId = Long.parseLong(id);
        if (!orderRepository.existsById(orderId)) {
            return "Order not found";
        }

        orderRepository.deleteById(orderId);
        return "Order deleted successfully";
    }


}
