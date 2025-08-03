package com.wipro.junittasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

class Factorial {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


public class FactorialTest {

	@Test
    public void testFactorialValidInputs() {
        assertEquals(1, Factorial.factorial(0));  // 0! = 1
        assertEquals(1, Factorial.factorial(1));  // 1! = 1
        assertEquals(2, Factorial.factorial(2));  // 2! = 2
        assertEquals(6, Factorial.factorial(3));  // 3! = 6
        assertEquals(24, Factorial.factorial(4)); // 4! = 24
        assertEquals(120, Factorial.factorial(5)); // 5! = 120
    }

    @Test
    public void testFactorialNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
    }


}
