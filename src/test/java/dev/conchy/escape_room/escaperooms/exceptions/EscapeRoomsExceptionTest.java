package dev.conchy.escape_room.escaperooms.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EscapeRoomsExceptionTest {

    @Test
    void testAddSuppressed() {
        EscapeRoomsException exception = new EscapeRoomsException("Main Exception");
        Throwable suppressedException = new IllegalArgumentException("Suppressed Exception");
        exception.addSuppressed(suppressedException);

        Throwable[] suppressed = exception.getSuppressed();
        assertEquals(1, suppressed.length);
        assertEquals(suppressedException, suppressed[0]);
    }

    @Test
    void testFillInStackTrace() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception with stack trace");
        Throwable filledException = exception.fillInStackTrace();
        assertNotNull(filledException.getStackTrace());
        assertEquals(exception, filledException);
    }

    @Test
    void testGetCause() {
        Throwable cause = new IllegalArgumentException("Cause of exception");
        EscapeRoomsException exception = new EscapeRoomsException("Exception with cause", cause);
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testGetLocalizedMessage() {
        EscapeRoomsException exception = new EscapeRoomsException("Localized exception message");
        assertEquals("Localized exception message", exception.getLocalizedMessage());
    }

    @Test
    void testGetMessage() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception message");
        assertEquals("Exception message", exception.getMessage());
    }

    @Test
    void testGetStackTrace() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception with stack trace");
        StackTraceElement[] stackTrace = exception.getStackTrace();
        assertNotNull(stackTrace);
        assertTrue(stackTrace.length > 0);
    }

    @Test
    void testGetSuppressed() {
        EscapeRoomsException exception = new EscapeRoomsException("Main Exception");
        assertEquals(0, exception.getSuppressed().length); 

        Throwable suppressedException = new IllegalArgumentException("Suppressed Exception");
        exception.addSuppressed(suppressedException);
        assertEquals(1, exception.getSuppressed().length);
        assertEquals(suppressedException, exception.getSuppressed()[0]);
    }

    @Test
    void testInitCause() {
        EscapeRoomsException exception = new EscapeRoomsException("Main Exception");
        Throwable cause = new IllegalArgumentException("Cause of exception");
        exception.initCause(cause);
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testPrintStackTrace() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception with stack trace");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        exception.printStackTrace(printStream);

        String printedStackTrace = outContent.toString();
        assertTrue(printedStackTrace.contains("EscapeRoomsException: Exception with stack trace"));
    }

    @Test
    void testPrintStackTrace2() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception with stack trace");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent)); 

        exception.printStackTrace();
        String printedStackTrace = outContent.toString();
        assertTrue(printedStackTrace.contains("EscapeRoomsException: Exception with stack trace"));
    }

    @Test
    void testPrintStackTrace3() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception with stack trace");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        exception.printStackTrace(printStream);

        String printedStackTrace = outContent.toString();
        assertTrue(printedStackTrace.contains("EscapeRoomsException: Exception with stack trace"));
    }

    @Test
    void testSetStackTrace() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception with custom stack trace");
        StackTraceElement[] customStackTrace = new StackTraceElement[]{
            new StackTraceElement("ClassName", "methodName", "FileName", 123)
        };

        exception.setStackTrace(customStackTrace);
        StackTraceElement[] returnedStackTrace = exception.getStackTrace();
        assertArrayEquals(customStackTrace, returnedStackTrace);
    }

    @Test
    void testToString() {
        EscapeRoomsException exception = new EscapeRoomsException("Exception with toString");
        String exceptionString = exception.toString();
        assertTrue(exceptionString.contains("EscapeRoomsException: Exception with toString"));
    }
}
// public class EscapeRoomsExceptionTest {

//     @Test
//     void testAddSuppressed() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error principal");
//         Throwable suppressed = new Exception("Error suprimido");
        
//         ex.addSuppressed(suppressed);
        
//         assertEquals(1, ex.getSuppressed().length);
//         assertEquals(suppressed, ex.getSuppressed()[0]);
//     }

//     @Test
//     void testFillInStackTrace() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error con traza de pila");
//         Throwable filledEx = ex.fillInStackTrace();
        
//         assertNotNull(filledEx);
//         assertEquals(ex, filledEx);  
//     }

//     @Test
//     void testGetCause() {
//         Throwable cause = new NullPointerException("Causa original");
//         EscapeRoomsException ex = new EscapeRoomsException("Error con causa", cause);
        
//         assertEquals(cause, ex.getCause());
//     }

//     @Test
//     void testGetLocalizedMessage() {
//         EscapeRoomsException ex = new EscapeRoomsException("Mensaje localizado");
        
//         assertEquals("Mensaje localizado", ex.getLocalizedMessage());
//     }

//     @Test
//     void testGetMessage() {
//         EscapeRoomsException ex = new EscapeRoomsException("Mensaje de error");
        
//         assertEquals("Mensaje de error", ex.getMessage());
//     }

//     @Test
//     void testGetStackTrace() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error con traza");
        
//         StackTraceElement[] stackTrace = ex.getStackTrace();
//         assertNotNull(stackTrace);
//         assertTrue(stackTrace.length > 0);
//     }

//     @Test
//     void testGetSuppressed() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error principal");
        
//         assertEquals(0, ex.getSuppressed().length);  

//         Throwable suppressed = new Exception("Error suprimido");
//         ex.addSuppressed(suppressed);
        
//         assertEquals(1, ex.getSuppressed().length);
//     }

//     @Test
//     void testInitCause() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error sin causa");
//         Throwable cause = new IllegalArgumentException("Causa del error");
        
//         Throwable result = ex.initCause(cause);
        
//         assertEquals(cause, ex.getCause());
//         assertEquals(ex, result);  
//     }

//     @Test
//     void testPrintStackTrace2() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error con impresión 2");


//         java.io.StringWriter sw = new java.io.StringWriter();
//         java.io.PrintWriter pw = new java.io.PrintWriter(sw);
//         ex.printStackTrace(pw);
        
//         String stackTraceOutput = sw.toString();
//         assertTrue(stackTraceOutput.contains("Error con impresión 2"));
//     }

//     @Test
//     void testPrintStackTrace3() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error con impresión 3");
        

//         assertDoesNotThrow(() -> ex.printStackTrace());
//     }

//     @Test
//     void testSetStackTrace() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error con ajuste de traza");

//         StackTraceElement[] newStackTrace = {
//             new StackTraceElement("Clase", "metodo", "Archivo.java", 123)
//         };
        
//         ex.setStackTrace(newStackTrace);
        
//         assertArrayEquals(newStackTrace, ex.getStackTrace());
//     }

//     @Test
//     void testToString() {
//         EscapeRoomsException ex = new EscapeRoomsException("Error con toString");
        
//         String result = ex.toString();
//         assertTrue(result.contains("EscapeRoomsException"));
//         assertTrue(result.contains("Error con toString"));
//     }

//     @Test
//     void testAddSuppressed2() {
        
//     }
// }
