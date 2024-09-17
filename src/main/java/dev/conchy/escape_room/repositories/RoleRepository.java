package dev.conchy.escape_room.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.conchy.escape_room.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {


}
