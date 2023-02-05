package com.example.game.exception;

public class ConnectionErrorException extends RuntimeException{

    public ConnectionErrorException() {
        super("Connection to VocabService failed");
    }
}
