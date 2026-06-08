package com.setintern.stockorder.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateOrder {
    @NotNull(message = "order id cannot be null")
    private String symbol;

    @NotNull(message = "price is required")
    @Positive(message = "price must be greater than 0")
    private int price;

    @Positive(message = "vol must be greater than 0")
    private int vol;

    public CreateOrder(String symbol, int price, int vol) {
        this.symbol = symbol;
        this.price = price;
        this.vol = vol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

}
