package ru.szhernovoy.nonblock;

/**
 * Created by admin on 27.10.2016.
 */
public class OptimisticException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public OptimisticException(String message) {
        super(message);
    }
}
