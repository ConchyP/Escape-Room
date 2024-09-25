package dev.conchy.escape_room.escaperooms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Escape room not found...")


public class EscapeRoomsNotFoundException extends EscapeRoomsException {

    public EscapeRoomsNotFoundException(String message){
        super(message);
    }

    public EscapeRoomsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}