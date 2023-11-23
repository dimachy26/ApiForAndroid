package com.dimachy.API.exception;

public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String message){
        super(message);
    }
}
