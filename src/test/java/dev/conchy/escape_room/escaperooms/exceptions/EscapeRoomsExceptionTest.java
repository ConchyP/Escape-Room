package dev.conchy.escape_room.escaperooms.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EscapeRoomsExceptionTest {

    @Test
    void testAddSuppressed() {
        EscapeRoomsException ex = new EscapeRoomsException("Error principal");
        Throwable suppressed = new Exception("Error suprimido");
        
        ex.addSuppressed(suppressed);
        
        assertEquals(1, ex.getSuppressed().length);
        assertEquals(suppressed, ex.getSuppressed()[0]);
    }

    @Test
    void testFillInStackTrace() {
        EscapeRoomsException ex = new EscapeRoomsException("Error con traza de pila");
        Throwable filledEx = ex.fillInStackTrace();
        
        assertNotNull(filledEx);
        assertEquals(ex, filledEx);  
    }

    @Test
    void testGetCause() {
        Throwable cause = new NullPointerException("Causa original");
        EscapeRoomsException ex = new EscapeRoomsException("Error con causa", cause);
        
        assertEquals(cause, ex.getCause());
    }

    @Test
    void testGetLocalizedMessage() {
        EscapeRoomsException ex = new EscapeRoomsException("Mensaje localizado");
        
        assertEquals("Mensaje localizado", ex.getLocalizedMessage());
    }

    @Test
    void testGetMessage() {
        EscapeRoomsException ex = new EscapeRoomsException("Mensaje de error");
        
        assertEquals("Mensaje de error", ex.getMessage());
    }

    @Test
    void testGetStackTrace() {
        EscapeRoomsException ex = new EscapeRoomsException("Error con traza");
        
        StackTraceElement[] stackTrace = ex.getStackTrace();
        assertNotNull(stackTrace);
        assertTrue(stackTrace.length > 0);
    }

    @Test
    void testGetSuppressed() {
        EscapeRoomsException ex = new EscapeRoomsException("Error principal");
        
        assertEquals(0, ex.getSuppressed().length);  

        Throwable suppressed = new Exception("Error suprimido");
        ex.addSuppressed(suppressed);
        
        assertEquals(1, ex.getSuppressed().length);
    }

    @Test
    void testInitCause() {
        EscapeRoomsException ex = new EscapeRoomsException("Error sin causa");
        Throwable cause = new IllegalArgumentException("Causa del error");
        
        Throwable result = ex.initCause(cause);
        
        assertEquals(cause, ex.getCause());
        assertEquals(ex, result);  
    }

    @Test
    void testPrintStackTrace2() {
        EscapeRoomsException ex = new EscapeRoomsException("Error con impresión 2");


        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw);
        ex.printStackTrace(pw);
        
        String stackTraceOutput = sw.toString();
        assertTrue(stackTraceOutput.contains("Error con impresión 2"));
    }

    @Test
    void testPrintStackTrace3() {
        EscapeRoomsException ex = new EscapeRoomsException("Error con impresión 3");
        
        // Verificar que la impresión estándar funciona
        assertDoesNotThrow(() -> ex.printStackTrace());
    }

    @Test
    void testSetStackTrace() {
        EscapeRoomsException ex = new EscapeRoomsException("Error con ajuste de traza");

        StackTraceElement[] newStackTrace = {
            new StackTraceElement("Clase", "metodo", "Archivo.java", 123)
        };
        
        ex.setStackTrace(newStackTrace);
        
        assertArrayEquals(newStackTrace, ex.getStackTrace());
    }

    @Test
    void testToString() {
        EscapeRoomsException ex = new EscapeRoomsException("Error con toString");
        
        String result = ex.toString();
        assertTrue(result.contains("EscapeRoomsException"));
        assertTrue(result.contains("Error con toString"));
    }
}
