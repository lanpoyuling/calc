package org.exception;

/**
 * 运算异常
 */
public class ArithException extends RuntimeException {
    public ArithException() {
        super();
    }

    public ArithException(String message) {
        super(message);
    }

    public ArithException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArithException(Throwable cause) {
        super(cause);
    }

    protected ArithException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
