package com.setintern.stockorder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @Column(name = "symbol", length = 20, nullable = false)
    private String symbol;

    @Column(name = "ceiling_price", nullable = false, precision = 15, scale = 4)
    private BigDecimal ceilingPrice;

    @Column(name = "floor_price", nullable = false, precision = 15, scale = 4)
    private BigDecimal floorPrice;

    public Stock() {}
    public Stock(String symbol, BigDecimal ceilingPrice, BigDecimal floorPrice) {
        this.symbol = symbol;
        this.ceilingPrice = ceilingPrice;
        this.floorPrice = floorPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(BigDecimal ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }
}
