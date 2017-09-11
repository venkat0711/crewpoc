package com.delta.css.excp;

public class DataAcesExcp extends Exception {
    private static final long serialVersionUID = 1L;
    private final Exception exception;

    /**
     * Creates a new DataAccessException wrapping another exception, and with a
     * detail message.
     * 
     * @param message
     *            the detail message.
     * @param exception
     *            the wrapped exception.
     */

    public DataAcesExcp(String message, Exception exception) {

        super(message);
        this.exception = exception;
        return;
    }

    /**
     * Creates a DataAccessException with the specified detail message.
     * 
     * @param message
     *            the detail message.
     */

    public DataAcesExcp(String message) {

        this(message, null);
        return;
    }

    /**
     * Creates a new DataAccessException wrapping another exception, and with no
     * detail message.
     * 
     * @param exception
     *            the wrapped exception.
     */

    public DataAcesExcp(Exception exception) {

        this(null, exception);
        return;
    }

    /**
     * Gets the wrapped exception.
     * 
     * @return the wrapped exception.
     */

    public Exception getException() {

        return exception;
    }

    /**
     * Retrieves (recursively) the root cause exception.
     * 
     * @return the root cause exception.
     */

    public Exception getRootCause() {

        if (exception instanceof DataAcesExcp) {
            return ((DataAcesExcp) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }

    @Override
    public String toString() {

        if (exception instanceof DataAcesExcp) {
            return ((DataAcesExcp) exception).toString();
        }
        return exception == null ? super.toString() : exception.toString();
    }
}
