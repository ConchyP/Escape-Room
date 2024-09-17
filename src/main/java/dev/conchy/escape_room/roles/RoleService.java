package dev.conchy.escape_room.roles;

import org.springframework.stereotype.Service;

import dev.conchy.escape_room.roles.exceptions.RoleException;

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