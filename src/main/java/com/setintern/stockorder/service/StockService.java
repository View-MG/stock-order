package com.setintern.stockorder.service;

import com.setintern.stockorder.entity.Stock;
import com.setintern.stockorder.repository.StockRepository;

import java.math.BigDecimal;
import java.util.List;

public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public List<Stock> getStocksByPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("price must be greater than 0");
        }

        return stockRepository.findStocksByPriceRange(price);
    }
}