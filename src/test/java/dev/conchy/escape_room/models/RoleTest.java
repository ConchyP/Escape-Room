package dev.conchy.escape_room.models;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import dev.conchy.escape_room.roles.Role;
import dev.conchy.escape_room.users.User;

public class RoleTest {

    @Test
    void testRoleId() {
        Role role = new Role();
        role.setId(1L);
        assertEquals(1L, role.getId());
    }

    @Test
    void testRoleName() {
        Role role = new Role();
        role.setName("Admin");
        assertEquals("Admin", role.getName());
    }

    @Test
    void testRoleUsers() {
        Role role = new Role();
        Set<User> users = new HashSet<>();
        role.setUsers(users);
        assertEquals(users, role.getUsers());
    }
}