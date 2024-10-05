package dev.conchy.escape_room.escaperooms.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import dev.conchy.escape_room.escaperooms.models.EscapeRoom;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@DataJpaTest 
public class EscapeRoomRepositoryTest {

    @Autowired
    private EscapeRoomRepository escapeRoomRepository;

    @BeforeEach
    void setUp() {
       
        escapeRoomRepository.deleteAll();

    
        escapeRoomRepository.save(new EscapeRoom(null, "Sala 1", "Descripción 1", "Alta", "imagen1.png"));
        escapeRoomRepository.save(new EscapeRoom(null, "Sala 2", "Descripción 2", "Media", "imagen2.png"));
        escapeRoomRepository.save(new EscapeRoom(null, "Sala 3", "Descripción 3", "Baja", "imagen3.png"));
        escapeRoomRepository.save(new EscapeRoom(null, "Sala 4", "Descripción 4", "Media", "imagen4.png"));
    }

    @Test
    void testFindByDificultad_Alta() {
        List<EscapeRoom> result = escapeRoomRepository.findByDificultad("Alta");

        assertEquals(1, result.size());
        assertEquals("Sala 1", result.get(0).getNombre());
    }

    @Test
    void testFindByDificultad_Media() {
        List<EscapeRoom> result = escapeRoomRepository.findByDificultad("Media");

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(room -> room.getNombre().equals("Sala 2")));
        assertTrue(result.stream().anyMatch(room -> room.getNombre().equals("Sala 4")));
    }

    @Test
    void testFindByDificultad_NoExistente() {
        List<EscapeRoom> result = escapeRoomRepository.findByDificultad("Extrema");

        assertTrue(result.isEmpty());
    }

    @Test
    void testSaveEscapeRoom() {
        EscapeRoom newEscapeRoom = new EscapeRoom(null, "Sala 5", "Descripción 5", "Alta", "imagen5.png");
        EscapeRoom savedEscapeRoom = escapeRoomRepository.save(newEscapeRoom);

        assertNotNull(savedEscapeRoom.getId());  
        assertEquals("Sala 5", savedEscapeRoom.getNombre());
        assertEquals("Alta", savedEscapeRoom.getDificultad());


        List<EscapeRoom> result = escapeRoomRepository.findByDificultad("Alta");
        assertEquals(2, result.size());  
    }

    @Test
    void testDeleteEscapeRoom() {
        List<EscapeRoom> initialResult = escapeRoomRepository.findByDificultad("Media");
        assertEquals(2, initialResult.size());

        
        escapeRoomRepository.delete(initialResult.get(0));

        List<EscapeRoom> afterDeleteResult = escapeRoomRepository.findByDificultad("Media");
        assertEquals(1, afterDeleteResult.size());  
    }

    @Test
    void testFindAll() {
        List<EscapeRoom> allRooms = escapeRoomRepository.findAll();

        assertEquals(4, allRooms.size());  
    }
}

