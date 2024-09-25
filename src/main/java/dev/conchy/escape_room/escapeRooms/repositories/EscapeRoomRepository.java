package dev.conchy.escape_room.escaperooms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  extends JpaRepository<EscapeRoom, Long> {

}
