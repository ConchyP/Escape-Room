package dev.conchy.escape_room.escaperooms.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.conchy.escape_room.escaperooms.exceptions.EscapeRoomsNotFoundException;
import dev.conchy.escape_room.escaperooms.models.EscapeRoom;
import dev.conchy.escape_room.escaperooms.repositories.EscapeRoomRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EscapeRoomServiceTest {

    @Mock
    private EscapeRoomRepository repository;

    @InjectMocks
    private EscapeRoomService service;

    private EscapeRoom escapeRoom;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        escapeRoom = new EscapeRoom(1L, "Casa de los horrores", "Siente el verdadero terror", "Alta", "image.jpg");
    }

    @Test
    void testCreateEscapeRoom() {
        when(repository.save(any(EscapeRoom.class))).thenReturn(escapeRoom);

        EscapeRoom createdEscapeRoom = service.createEscapeRoom(escapeRoom);

        assertNotNull(createdEscapeRoom);
        assertEquals(escapeRoom.getId(), createdEscapeRoom.getId());
        verify(repository, times(1)).save(escapeRoom);
    }

    @Test
    void testDeleteEscapeRoomById() {
        when(repository.existsById(escapeRoom.getId())).thenReturn(true);

        service.deleteEscapeRoomById(escapeRoom.getId());

        verify(repository, times(1)).deleteById(escapeRoom.getId());
    }

    @Test
    void testFindByDificultad() {
        List<EscapeRoom> expectedRooms = Arrays.asList(escapeRoom);
        when(repository.findByDificultad("Alta")).thenReturn(expectedRooms);

        List<EscapeRoom> result = service.findByDificultad("Alta");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(expectedRooms, result);
        verify(repository, times(1)).findByDificultad("Alta");
    }

    @Test
    void testGetAllEscapeRooms() {
        List<EscapeRoom> expectedRooms = Arrays.asList(escapeRoom);
        when(repository.findAll()).thenReturn(expectedRooms);

        List<EscapeRoom> result = service.getAllEscapeRooms();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(expectedRooms, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetEscapeRoomById() {
        when(repository.findById(escapeRoom.getId())).thenReturn(Optional.of(escapeRoom));

        EscapeRoom result = service.getEscapeRoomById(escapeRoom.getId());

        assertNotNull(result);
        assertEquals(escapeRoom.getId(), result.getId());
        verify(repository, times(1)).findById(escapeRoom.getId());
    }

    @Test
    void testGetEscapeRoomById_NotFound() {
        when(repository.findById(escapeRoom.getId())).thenReturn(Optional.empty());

        assertThrows(EscapeRoomsNotFoundException.class, () -> service.getEscapeRoomById(escapeRoom.getId()));
        verify(repository, times(1)).findById(escapeRoom.getId());
    }

    @Test
    void testUpdateEscapeRoom() {
        when(repository.existsById(escapeRoom.getId())).thenReturn(true);
        when(repository.save(escapeRoom)).thenReturn(escapeRoom);

        EscapeRoom updatedEscapeRoom = service.updateEscapeRoom(escapeRoom);

        assertNotNull(updatedEscapeRoom);
        assertEquals(escapeRoom.getId(), updatedEscapeRoom.getId());
        verify(repository, times(1)).save(escapeRoom);
    }

    @Test
    void testUpdateEscapeRoom_NotFound() {
        when(repository.existsById(escapeRoom.getId())).thenReturn(false);

        assertThrows(EscapeRoomsNotFoundException.class, () -> service.updateEscapeRoom(escapeRoom));
        verify(repository, times(1)).existsById(escapeRoom.getId());
    }
    
}
