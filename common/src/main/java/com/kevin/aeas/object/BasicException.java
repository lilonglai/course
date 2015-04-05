package com.kevin.aeas.object;

/**
 * Created by loli on 2015/4/5.
 */
public class BasicException extends RuntimeException {
    public BasicException(){
        super();
    }

    public BasicException(String message){
        super(message);
    }

    public BasicException(Throwable cause){
        super(cause);
    }

    public BasicException(String message, Throwable cause){
        super(message, cause);
    }
}
