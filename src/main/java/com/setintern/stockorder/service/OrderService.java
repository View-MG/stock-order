package com.setintern.stockorder.service;

import com.setintern.stockorder.dto.CreateOrder;
import com.setintern.stockorder.dto.UpdateOrder;
import com.setintern.stockorder.entity.Order;
import com.setintern.stockorder.entity.Stock;
import com.setintern.stockorder.repository.OrderRepository;
import com.setintern.stockorder.repository.StockRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final StockRepository stockRepository;
    public OrderService(OrderRepository orderRepository, StockRepository stockRepository) {
        this.orderRepository = orderRepository;
        this.stockRepository = stockRepository;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(String id) {
        Long orderId;
        try {
            orderId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order ID  ust be number");
        }

        return orderRepository.findById(orderId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }


    public String createOrder(CreateOrder req){
        Stock stock = stockRepository.findById(req.getSymbol())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Symbol"));

        validatePriceAndVolume(stock, req.getPrice(), req.getVol());
        Order order = new Order(req.getSymbol(), req.getPrice(), req.getVol());
        order.setOrderDate(LocalDateTime.now());

        orderRepository.save(order);
        return "Order created successfully";
    }

    public String updateOrder(String id, UpdateOrder req){
        Order order = getOrder(id);

        Stock stock = stockRepository.findById(order.getSymbol())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Symbol"));


        validatePriceAndVolume(stock, req.getPrice(), req.getVol());
        order.setPrice(req.getPrice());
        order.setVol(req.getVol());
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);

        return "Order updated successfully";
    }

    public  String deleteOrder(String id){
        Order order = getOrder(id);

        orderRepository.delete(order);
        return "Order deleted successfully";
    }

    private void validatePriceAndVolume(Stock stock, BigDecimal price, int vol){
        if(!(price.compareTo(stock.getFloorPrice()) > 0 && price.compareTo(stock.getCeilingPrice()) < 0))
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), "Price is out of range");

        if (vol <=0 || vol % 100 != 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Volume must be positive and multiple of 100");
    }
}

