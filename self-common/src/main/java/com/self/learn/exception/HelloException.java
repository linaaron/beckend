package com.self.learn.exception;

public class HelloException extends Exception {

    public HelloException() {
        super();
    }

    public HelloException(String message) {
        super(message);
    }

    public HelloException(String message, Throwable cause) {
        super(message, cause);
    }

    public HelloException(Throwable cause) {
        super(cause);
    }
}
