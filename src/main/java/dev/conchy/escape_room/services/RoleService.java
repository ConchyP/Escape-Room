package dev.conchy.escape_room.services;

import javax.management.relation.RoleNotFoundException;

import org.springframework.stereotype.Service;

import dev.conchy.escape_room.models.Role;
import dev.conchy.escape_room.repositories.RoleRepository;

@Service
public class RoleService {
     RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
}

public Role getById(Long id) {
        Role role = repository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found"));
        return role;
    }

}