package dev.conchy.escape_room.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserDtoTest {

    @Test
    public void testUserDtoConstructorAndGetters() {
      
        String expectedUsername = "testUser";
        String expectedPassword = "testPassword";

   
        UserDto userDto = new UserDto(expectedUsername, expectedPassword);

        
        assertEquals(expectedUsername, userDto.getUsername(), "El username debe ser igual al valor esperado.");

        assertEquals(expectedPassword, userDto.getPassword(), "El password debe ser igual al valor esperado.");
    }
}

