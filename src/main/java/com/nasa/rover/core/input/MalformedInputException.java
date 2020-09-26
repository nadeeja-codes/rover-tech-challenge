package com.nasa.rover.core.input;

public class MalformedInputException extends Exception {
    public MalformedInputException(String msg){
        super(msg);
    }


    public MalformedInputException(String msg, Exception cause){
        super(msg, cause);
    }
}
