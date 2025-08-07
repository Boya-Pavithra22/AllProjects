package com.wipro.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

//circuitbreaker

@RestController
@RequestMapping("/api")
public class OrderController {

    private static final String DELIVERY_SERVICE = "deliveryService";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/check")
    @CircuitBreaker(name = DELIVERY_SERVICE, fallbackMethod = "fallbackCheckDelivery")
    public String checkDelivery() {
        String url = "http://localhost:8081/delivery/status";
        return restTemplate.getForObject(url, String.class);
    }

    // Fallback must accept a Throwable parameter
    public String fallbackCheckDelivery(Throwable t) {
        System.out.println("Fallback triggered due to: " + t.getMessage());

        return "Fallback response: Delivery service is currently unavailable. Please try again later.";
    }
}