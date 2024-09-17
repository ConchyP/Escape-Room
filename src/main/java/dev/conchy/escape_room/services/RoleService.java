package dev.conchy.escape_room.services;

import org.springframework.stereotype.Service;

import dev.conchy.escape_room.exceptions.RoleException;
import dev.conchy.escape_room.models.Role;
import dev.conchy.escape_room.repositories.RoleRepository;

@Service
public class RoleService {
     RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
}

public Role getById(Long id) {
        Role role = repository.findById(id).orElseThrow(() -> new RoleException("Role not found"));
        return role;
    }

}