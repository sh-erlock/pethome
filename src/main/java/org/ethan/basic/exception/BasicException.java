package org.ethan.basic.exception;

/**
 * 自定义异常
 */
public class BasicException extends RuntimeException{

    public BasicException() {
    }

    public BasicException(String message) {
        super(message);
    }
}
