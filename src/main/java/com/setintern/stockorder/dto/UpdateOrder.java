package com.setintern.stockorder.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class UpdateOrder {
    @NotNull(message = "price is required")
    @Positive(message = "price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "vol is required")
    @Positive(message = "vol must be greater than 0")
    private int vol;

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
