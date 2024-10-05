package dev.conchy.escape_room.register.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserAlreadyExistsExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "El usuario ya existe";
        UserAlreadyExistsException exception = new UserAlreadyExistsException(expectedMessage);
        
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testExceptionInheritance() {
        UserAlreadyExistsException exception = new UserAlreadyExistsException("Test message");
        
        assertEquals(RuntimeException.class, exception.getClass().getSuperclass());
    }
}
