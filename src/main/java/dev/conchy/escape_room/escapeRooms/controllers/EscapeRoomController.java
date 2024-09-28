package dev.conchy.escape_room.escaperooms.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.conchy.escape_room.escaperooms.models.EscapeRoom;
import dev.conchy.escape_room.escaperooms.services.EscapeRoomService;

@RestController
@RequestMapping(path = "api/v1/escapeRooms")
public class EscapeRoomController {

    private final EscapeRoomService escapeRoomService;

    public EscapeRoomController(EscapeRoomService escapeRoomService) {
        this.escapeRoomService = escapeRoomService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<EscapeRoom>> getAllEscapeRooms() {
        List<EscapeRoom> escapeRooms = escapeRoomService.getAllEscapeRooms();
        return ResponseEntity.ok(escapeRooms);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EscapeRoom> getEscapeRoomById(@PathVariable Long id) {
        EscapeRoom escapeRoom = escapeRoomService.getEscapeRoomById(id);
        return ResponseEntity.ok(escapeRoom);
    }

    @PostMapping("/create")
    public ResponseEntity<EscapeRoom> createEscapeRoom(@RequestBody EscapeRoom escapeRoom) {
        EscapeRoom createdEscapeRoom = escapeRoomService.createEscapeRoom(escapeRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEscapeRoom);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EscapeRoom> updateEscapeRoom(@RequestBody EscapeRoom escapeRoom, @PathVariable Long id) {
        escapeRoom.setId(id);
        EscapeRoom updatedEscapeRoom = escapeRoomService.updateEscapeRoom(escapeRoom);
        return ResponseEntity.ok(updatedEscapeRoom);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEscapeRoomById(@PathVariable Long id) {
        escapeRoomService.deleteEscapeRoomById(id);
        return ResponseEntity.noContent().build(); 
    }
}
