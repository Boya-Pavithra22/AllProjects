package com.wipro.junittasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

class LoginValidator {
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }
        return username.equals("satya") && password.equals("satya123");
    }
}



public class LoginValidatorTest {
	LoginValidator validator = new LoginValidator();

    @Test
    public void testValidLogin() {
        assertTrue(validator.validate("satya", "satya123"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(validator.validate("user", "satya123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(validator.validate("satya", "wrongpass"));
    }

    @Test
    public void testInvalidUsernameAndPassword() {
        assertFalse(validator.validate("user", "pass"));
    }

    @Test
    public void testNullUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            validator.validate(null, "satya123"));
        assertEquals("Username or password cannot be null", exception.getMessage());
    }

    @Test
    public void testNullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            validator.validate("satya", null));
        assertEquals("Username or password cannot be null", exception.getMessage());
    }

    @Test
    public void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            validator.validate("", "satya123"));
        assertEquals("Username or password cannot be empty", exception.getMessage());
    }

    @Test
    public void testEmptyPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            validator.validate("satya", ""));
        assertEquals("Username or password cannot be empty", exception.getMessage());
    }
}