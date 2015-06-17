package com.imagine.world.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by letuan on 6/25/14.
 */
public class AuthorizationException extends MyException {

    public AuthorizationException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
