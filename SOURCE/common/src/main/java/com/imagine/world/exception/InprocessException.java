package com.imagine.world.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by letuan on 6/26/14.
 */
public class InprocessException extends MyException{
    public InprocessException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
