package com.wipro.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.wipro.service.ShoppingService.purchaseItems(..))")
    public void logBeforePurchase() {
        System.out.println("📢 Before purchasing, LoggingAspect: purchaseItems");
    }
}
