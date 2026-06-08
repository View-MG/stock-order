package com.setintern.stockorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}