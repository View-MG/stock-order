package com.setintern.stockorder.controller;

import com.setintern.stockorder.entity.Stock;
import com.setintern.stockorder.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public List<Stock> getStocks(@RequestParam(required = false) BigDecimal price) {
        if (price == null) {
            return stockService.getStocks();
        }

        return stockService.getStocksByPrice(price);
    }
}
