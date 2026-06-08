package com.setintern.stockorder.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "symbol", length = 20, nullable = false)
    private String symbol;

    @Column(name = "price", precision = 15, scale = 4, nullable = false)
    private BigDecimal price;

    @Column(name = "vol", nullable = false)
    private Integer vol;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    public Order(){}
    public Order(String symbol, BigDecimal price, int vol) {
        this.symbol = symbol;
        this.price = price;
        this.vol = vol;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
