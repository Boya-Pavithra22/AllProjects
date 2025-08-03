package com.wipro.junittasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

class ReverseString{
    public static String reverse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(str).reverse().toString();
    }
}



public class ReverseStringTest 
{
	 @Test
	    public void testReverseRegularString() {
	        assertEquals("aytas", ReverseString.reverse("satya"));
	        assertEquals("54321", ReverseString.reverse("12345"));
	    }

	    @Test
	    public void testReverseEmptyString() {
	        assertEquals("", ReverseString.reverse(""));
	    }

	    @Test
	    public void testReverseNullInput() {
	        assertThrows(IllegalArgumentException.class, () -> {
	        	ReverseString.reverse(null);
	        });
	    }

}
