package dev.conchy.escape_room.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.conchy.escape_room.users.User;

public class ProfileTest {

    private Profile profile;
    private User user;

    @BeforeEach
    public void setUp() {

        user = new User();
        user.setId(1L);
        user.setUsername("Test User");

        profile = new Profile(1L, user);
    }

    @Test
    public void testGetId() {
        assertEquals(1L, profile.getId());
    }

    @Test
    public void testSetId() {
        profile.setId(2L);
        assertEquals(2L, profile.getId());
    }

    @Test
    public void testGetUsername() {
        // assertEquals(user profile.getUsername());
        assertEquals(user, profile.getUser());
    }

    @Test
    public void testSetUser() {
        User newUser = new User();
        newUser.setId(2L);
        newUser.setUsername("Another User");
        profile.setUser(newUser);
        assertEquals(newUser, profile.getUser());
    }

    @Test
    public void testDefaultConstructor() {
        Profile defaultProfile = new Profile();
        assertEquals(null, defaultProfile.getId());
        assertEquals(null, defaultProfile.getUser());
    }
}
