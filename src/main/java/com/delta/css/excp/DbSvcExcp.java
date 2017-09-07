package com.delta.css.excp;



public class DbSvcExcp extends Exception {
    private static final long serialVersionUID = 1L;
    private Exception exception;

    /**
     * Creates a new DbSvcExcp wrapping another exception, and with a detail
     * message.
     * 
     * @param message
     *            the detail message.
     * @param exception
     *            the wrapped exception.
     */

    public DbSvcExcp(String message, Exception exception) {

        super(message);
        this.exception = exception;
        return;
    }

    /**
     * Creates a BsnObjExcp with the specified detail message.
     * 
     * @param message
     *            the detail message.
     */

    public DbSvcExcp(String message) {

        this(message, null);
        return;
    }

    /**
     * Creates a new BsnObjExcp wrapping another exception, and with no detail
     * message.
     * 
     * @param exception
     *            the wrapped exception.
     */

    public DbSvcExcp(Exception exception) {

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

        if (exception instanceof DbSvcExcp) {
            return ((DbSvcExcp) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }

    public String toString() {

        if (exception instanceof DbSvcExcp) {
            return ((DbSvcExcp) exception).toString();
        }
        return exception == null ? super.toString() : exception.toString();
    }
}
