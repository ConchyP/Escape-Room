package dev.conchy.escape_room.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.conchy.escape_room.roles.RoleRepository;
import dev.conchy.escape_room.roles.RoleService;
import dev.conchy.escape_room.roles.exceptions.RoleException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class RoleServiceTest {

    @Mock
    private RoleRepository repository;

    @InjectMocks
    private RoleService service;

    public RoleServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetByIdNotFound() {
       
        when(repository.findById(1L)).thenReturn(Optional.empty());

        
        assertThrows(RoleException.class, () -> {
            service.getById(1L);
        });
    }
}

