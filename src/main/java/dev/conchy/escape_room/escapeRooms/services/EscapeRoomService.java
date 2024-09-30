package dev.conchy.escape_room.escaperooms.services;

import java.util.List;

import dev.conchy.escape_room.escaperooms.exceptions.EscapeRoomsNotFoundException;

import dev.conchy.escape_room.escaperooms.repositories.EscapeRoomRepository;
import dev.conchy.escape_room.escaperooms.models.EscapeRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EscapeRoomService {

    @Autowired
    private EscapeRoomRepository repository;

    public List<EscapeRoom> getAllEscapeRooms() {
        return repository.findAll();
    }

    public EscapeRoom getEscapeRoomById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EscapeRoomsNotFoundException("Escape Room not found"));
    }

    public EscapeRoom createEscapeRoom(EscapeRoom escapeRoom) {
        return repository.save(escapeRoom);
    }

    public EscapeRoom updateEscapeRoom(EscapeRoom escapeRoom) {
        if (!repository.existsById(escapeRoom.getId())) {
            throw new EscapeRoomsNotFoundException("Escape Room not found");
        }
        return repository.save(escapeRoom);
    }

    public void deleteEscapeRoomById(Long id) {
        if (!repository.existsById(id)) {
            throw new EscapeRoomsNotFoundException("Escape Room not found");
        }
        repository.deleteById(id);
    }

    public List<EscapeRoom> findEscapeRoomsByDificultad(String dificultad) {
        return EscapeRoomRepository.findByDificultad(dificultad);
    }
}