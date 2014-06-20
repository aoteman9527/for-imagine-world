package com.imagine.world.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by letuan on 6/19/14.
 */
public class LoginInvalidUserException extends MyException{
    public LoginInvalidUserException(String message){
        super(message);
    }
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
