package dev.conchy.escape_room.security.implementations;

public interface IEncryptFacade {

    String encode(String type, String data);

    String decode(String type, String data);

}