package com.wipro.mockitotasks;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

class PaymentService {
    public void processPayment() {
        System.out.println("Payment processed.");
    }
}

class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment();
    }
}

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest 
{

	 @Mock
	    PaymentService paymentService;

	    @InjectMocks
	    OrderService orderService;

	    @Test
	    public void testPlaceOrderCallsProcessPaymentOnce() {
	        orderService.placeOrder();

	        verify(paymentService, times(1)).processPayment(); 
	    }
	}
