package dev.conchy.escape_room.register;

import dev.conchy.escape_room.users.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/register")

public class RegisterController {

        private final RegisterService service;

    @Autowired
    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> register (@RequestBody UserDto newUser) {
        try {
            return ResponseEntity.ok(service.save(newUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during registration");
        }
    }

}