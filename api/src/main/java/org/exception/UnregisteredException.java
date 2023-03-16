package org.exception;

/**
 * 未注册异常
 */
public class UnregisteredException extends RuntimeException{
    public UnregisteredException() {
        super();
    }

    public UnregisteredException(String message) {
        super(message);
    }

    public UnregisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnregisteredException(Throwable cause) {
        super(cause);
    }

    protected UnregisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

