package dev.conchy.escape_room.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import dev.conchy.escape_room.role.exceptions.RoleNotFoundException;

public class RoleNotFoundExceptionTest {
 @Test
    void testRoleNotFoundExceptionMessage() {
        String message = "Role not found";
        RoleNotFoundException exception = new RoleNotFoundException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testRoleNotFoundExceptionMessageAndCause() {
        String message = "Role not found";
        Throwable cause = new Throwable("Cause of the exception");
        RoleNotFoundException exception = new RoleNotFoundException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testRoleNotFoundExceptionCause() {
        Throwable cause = new Throwable("Cause of the exception");
        RoleNotFoundException exception = new RoleNotFoundException(cause.getMessage(), cause);
        assertEquals(cause.getMessage(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testRoleNotFoundExceptionNoArgs() {
        RoleNotFoundException exception = new RoleNotFoundException(null);
        assertNull(exception.getMessage());
    }
}
