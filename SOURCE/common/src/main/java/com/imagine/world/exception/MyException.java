package com.imagine.world.exception;

/**
 * Created by letuan on 6/17/14.
 */
public abstract class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public abstract int getStatusCode();
}
