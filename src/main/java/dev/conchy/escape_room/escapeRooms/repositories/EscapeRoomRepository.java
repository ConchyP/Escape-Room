package dev.conchy.escape_room.escaperooms.repositories;

import dev.conchy.escape_room.escaperooms.models.EscapeRoom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EscapeRoomRepository extends JpaRepository<EscapeRoom, Long>{

    static List<EscapeRoom> findByDificultad(String dificultad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDificultad'");
    }
}
