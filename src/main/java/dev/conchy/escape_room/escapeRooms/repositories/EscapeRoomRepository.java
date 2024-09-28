package dev.conchy.escape_room.escaperooms.repositories;

import dev.conchy.escape_room.escaperooms.models.EscapeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EscapeRoomRepository extends JpaRepository<EscapeRoom, Long>{

}
