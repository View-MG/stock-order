package com.setintern.stockorder.repository;

import com.setintern.stockorder.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, String> {
    @Query("""
            SELECT s
            FROM Stock s
            WHERE s.floorPrice <= :price
            AND s.ceilingPrice >= :price
            """)
    List<Stock> findStocksByPriceRange(@Param("price") BigDecimal price);
}