package dev.conchy.escape_room.escaperooms.controllers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dev.conchy.escape_room.escaperooms.exceptions.EscapeRoomsNotFoundException;
import dev.conchy.escape_room.escaperooms.models.EscapeRoom;
import dev.conchy.escape_room.escaperooms.services.EscapeRoomService;

public class EscapeRoomControllerTest {

    @Mock
    private EscapeRoomService escapeRoomService;

    @InjectMocks
    private EscapeRoomController escapeRoomController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEscapeRooms() {
        List<EscapeRoom> mockEscapeRooms = Arrays.asList(
                new EscapeRoom(1L, "Escape Room 1", "Descripción 1", "Bajo", "image-url-1"),
                new EscapeRoom(2L, "Escape Room 2", "Descripción 2", "Medio", "image-url-2")
        );

        when(escapeRoomService.getAllEscapeRooms()).thenReturn(mockEscapeRooms);

        ResponseEntity<List<EscapeRoom>> response = escapeRoomController.getAllEscapeRooms();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(escapeRoomService, times(1)).getAllEscapeRooms();
    }

    @Test
    public void testGetEscapeRoomByIdSuccess() {
        EscapeRoom mockEscapeRoom = new EscapeRoom(1L, "Escape Room 1", "Descripción 1", "Bajo", "image-url");
        when(escapeRoomService.getEscapeRoomById(1L)).thenReturn(mockEscapeRoom);

        ResponseEntity<EscapeRoom> response = escapeRoomController.getEscapeRoomById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Escape Room 1", response.getBody().getNombre());
        verify(escapeRoomService, times(1)).getEscapeRoomById(1L);
    }


    @Test
    public void testCreateEscapeRoom() {
        EscapeRoom newEscapeRoom = new EscapeRoom(null, "Escape Room 3", "Descripción 3", "Alto", "image-url");
        EscapeRoom createdEscapeRoom = new EscapeRoom(3L, "Escape Room 3", "Descripción 3", "Alto", "image-url");

        when(escapeRoomService.createEscapeRoom(newEscapeRoom)).thenReturn(createdEscapeRoom);

        ResponseEntity<EscapeRoom> response = escapeRoomController.createEscapeRoom(newEscapeRoom);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Escape Room 3", response.getBody().getNombre());
        verify(escapeRoomService, times(1)).createEscapeRoom(newEscapeRoom);
    }

    @Test
    public void testUpdateEscapeRoomSuccess() {
        EscapeRoom existingEscapeRoom = new EscapeRoom(1L, "Escape Room 1", "Descripción 1", "Bajo", "image-url");
        when(escapeRoomService.updateEscapeRoom(existingEscapeRoom)).thenReturn(existingEscapeRoom);

        ResponseEntity<EscapeRoom> response = escapeRoomController.updateEscapeRoom(existingEscapeRoom, 1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Escape Room 1", response.getBody().getNombre());
        verify(escapeRoomService, times(1)).updateEscapeRoom(existingEscapeRoom);
    }

    @Test
    public void testDeleteEscapeRoomSuccess() {
        doNothing().when(escapeRoomService).deleteEscapeRoomById(1L);

        ResponseEntity<Void> response = escapeRoomController.deleteEscapeRoomById(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(escapeRoomService, times(1)).deleteEscapeRoomById(1L);
    }

    @Test
    public void testFilterByDificultad() {
        List<EscapeRoom> mockEscapeRooms = Arrays.asList(
                new EscapeRoom(1L, "Escape Room 1", "Descripción 1", "Bajo", "image-url-1"),
                new EscapeRoom(2L, "Escape Room 2", "Descripción 2", "Bajo", "image-url-2")
        );

        when(escapeRoomService.findByDificultad("Bajo")).thenReturn(mockEscapeRooms);

        ResponseEntity<List<EscapeRoom>> response = escapeRoomController.filterByDificultad("Bajo");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(escapeRoomService, times(1)).findByDificultad("Bajo");
    }

    // Añadir más pruebas según sea necesario
}
