package by.epam.interpol.exception;

public class ServiceException extends Throwable {

    /**
     * Value of the exception message.
     */
    private String message;

    /**
     * Public default constructor.
     */
    public ServiceException() {

        super();

    }

    /**
     * Public initialize constructor.
     *
     * @param newMessage new value of the exception message
     */
    public ServiceException(final String newMessage) {

        super(newMessage);

        this.message = newMessage;

    }

    /**
     * Public initialize constructor.
     *
     * @param throwable new value of the object Throwable
     */
    public ServiceException(final Throwable throwable) {

        super(throwable);

    }

    /**
     * Public initialize constructor.
     *
     * @param newMessage new value of the exception message
     * @param throwable  new value of the object Throwable
     */
    public ServiceException(final String newMessage,
                        final Throwable throwable) {

        super(newMessage, throwable);

    }

    /**
     * This method return value of the exception message.
     *
     * @return value of the exception message
     */
    public String getMessage() {

        return this.message;

    }

    /**
     * This method set new value of the exception message.
     *
     * @param newMessage new value of the exception message
     */
    public void setMessage(final String newMessage) {

        this.message = newMessage;

    }
}
