package com.setintern.stockorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StockOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockOrderApplication.class, args);
	}

	@GetMapping("/greet")
	public String greet() {
		return "Hello";
	}
}
