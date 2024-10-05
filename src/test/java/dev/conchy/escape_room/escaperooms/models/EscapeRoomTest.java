package dev.conchy.escape_room.escaperooms.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EscapeRoomTest {

    @Test
    void testConstructorCompleto() {
        EscapeRoom escapeRoom = new EscapeRoom(1L, "Sala Misteriosa", "Descripción de la sala", "Media", "imagen.png");
        assertEquals(1L, escapeRoom.getId());
        assertEquals("Sala Misteriosa", escapeRoom.getNombre());
        assertEquals("Descripción de la sala", escapeRoom.getDescripcion());
        assertEquals("Media", escapeRoom.getDificultad());
        assertEquals("imagen.png", escapeRoom.getImage());
    }

    @Test
    void testConstructorVacio() {
        EscapeRoom escapeRoom = new EscapeRoom();
        assertNull(escapeRoom.getId());
        assertNull(escapeRoom.getNombre());
        assertNull(escapeRoom.getDescripcion());
        assertNull(escapeRoom.getDificultad());
        assertNull(escapeRoom.getImage());
    }

    @Test
    void testGetDescripcion() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setDescripcion("Sala de misterio");
        assertEquals("Sala de misterio", escapeRoom.getDescripcion());

        escapeRoom.setDescripcion(null);
        assertNull(escapeRoom.getDescripcion());
    }

    @Test
    void testGetDificultad() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setDificultad("Alta");
        assertEquals("Alta", escapeRoom.getDificultad());

        
        escapeRoom.setDificultad(null);
        assertNull(escapeRoom.getDificultad());
    }

    @Test
    void testGetId() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setId(1L);
        assertEquals(1L, escapeRoom.getId());

       
        escapeRoom.setId(null);
        assertNull(escapeRoom.getId());
    }

    @Test
    void testGetImage() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setImage("imagen.png");
        assertEquals("imagen.png", escapeRoom.getImage());

      
        escapeRoom.setImage(null);
        assertNull(escapeRoom.getImage());
    }

    @Test
    void testGetNombre() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setNombre("Aventura en el bosque");
        assertEquals("Aventura en el bosque", escapeRoom.getNombre());

        
        escapeRoom.setNombre(null);
        assertNull(escapeRoom.getNombre());
    }

    @Test
    void testSetDescripcion() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setDescripcion("Sala del terror");
        assertEquals("Sala del terror", escapeRoom.getDescripcion());

      
        escapeRoom.setDescripcion("");
        assertEquals("", escapeRoom.getDescripcion());
    }

    @Test
    void testSetDificultad() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setDificultad("Media");
        assertEquals("Media", escapeRoom.getDificultad());

        
        escapeRoom.setDificultad("");
        assertEquals("", escapeRoom.getDificultad());
    }

    @Test
    void testSetId() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setId(2L);
        assertEquals(2L, escapeRoom.getId());

        // Test con valor nulo
        escapeRoom.setId(null);
        assertNull(escapeRoom.getId());
    }

    @Test
    void testSetImage() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setImage("nueva_imagen.jpg");
        assertEquals("nueva_imagen.jpg", escapeRoom.getImage());

     
        escapeRoom.setImage("");
        assertEquals("", escapeRoom.getImage());
    }

    @Test
    void testSetNombre() {
        EscapeRoom escapeRoom = new EscapeRoom();
        escapeRoom.setNombre("El secreto del faraón");
        assertEquals("El secreto del faraón", escapeRoom.getNombre());

        
        escapeRoom.setNombre("");
        assertEquals("", escapeRoom.getNombre());
    }

    @Test
    void testEqualsEscapeRooms() {
        EscapeRoom room1 = new EscapeRoom(1L, "Sala 1", "Una descripción", "Media", "image1.png");
        EscapeRoom room2 = new EscapeRoom(1L, "Sala 1", "Una descripción", "Media", "image1.png");

        assertEquals(room1.getId(), room2.getId());
        assertEquals(room1.getNombre(), room2.getNombre());
        assertEquals(room1.getDescripcion(), room2.getDescripcion());
        assertEquals(room1.getDificultad(), room2.getDificultad());
        assertEquals(room1.getImage(), room2.getImage());
    }

    
    @Test
    void testNotEqualsEscapeRooms() {
        EscapeRoom room1 = new EscapeRoom(1L, "Sala 1", "Una descripción", "Media", "image1.png");
        EscapeRoom room2 = new EscapeRoom(2L, "Sala 2", "Otra descripción", "Alta", "image2.png");

        assertNotEquals(room1.getId(), room2.getId());
        assertNotEquals(room1.getNombre(), room2.getNombre());
        assertNotEquals(room1.getDescripcion(), room2.getDescripcion());
        assertNotEquals(room1.getDificultad(), room2.getDificultad());
        assertNotEquals(room1.getImage(), room2.getImage());
    }
}

