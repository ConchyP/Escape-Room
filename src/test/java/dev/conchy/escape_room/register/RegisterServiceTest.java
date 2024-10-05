package dev.conchy.escape_room.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.conchy.escape_room.facades.implementations.IEncryptFacade;
import dev.conchy.escape_room.roles.Role;
import dev.conchy.escape_room.roles.RoleService;
import dev.conchy.escape_room.users.User;
import dev.conchy.escape_room.users.UserDto;
import dev.conchy.escape_room.users.UserRepository;

public class RegisterServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleService roleService;

    @Mock
    private IEncryptFacade encoderFacade;

    @InjectMocks
    private RegisterService registerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUserSuccessfully() {
        // Datos de prueba
        UserDto newUserDto = new UserDto("testUser", "passwordEncoded");
        Role defaultRole = new Role(); 

        
        when(encoderFacade.decode("base64", "passwordEncoded")).thenReturn("passwordDecoded");
        when(encoderFacade.encode("bcrypt", "passwordDecoded")).thenReturn("hashedPassword");
        when(roleService.getById(1L)).thenReturn(defaultRole);


        String result = registerService.save(newUserDto);

  
        assertEquals("Success", result);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testAssignDefaultRole() {
       
        Role defaultRole = new Role();
        when(roleService.getById(1L)).thenReturn(defaultRole);


        Set<Role> roles = registerService.assignDefaultRole();

 
        assertEquals(1, roles.size());
        assertEquals(defaultRole, roles.iterator().next());
    }

    @Test
    public void testSaveUserWhenRoleNotFound() {
        
        UserDto newUserDto = new UserDto("testUser", "passwordEncoded");

        
        when(encoderFacade.decode("base64", "passwordEncoded")).thenReturn("passwordDecoded");
        when(encoderFacade.encode("bcrypt", "passwordDecoded")).thenReturn("hashedPassword");
        when(roleService.getById(1L)).thenReturn(null); 
     
        Exception exception = assertThrows(NullPointerException.class, () -> {
            registerService.save(newUserDto);
        });

        String expectedMessage = "Role not found"; 
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}
