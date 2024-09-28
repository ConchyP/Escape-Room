package dev.conchy.escape_room.escaperooms.exceptions;

public class EscapeRoomsException  extends RuntimeException {

    public EscapeRoomsException(String message) {
        super(message);
    }

    public EscapeRoomsException(String message, Throwable cause) {
        super(message, cause);
    }
}