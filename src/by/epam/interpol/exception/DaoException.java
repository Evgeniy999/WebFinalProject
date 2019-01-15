package by.epam.interpol.exception;

/**
 * The type Dao exception.
 */
public class DaoException extends Throwable {

    /** Value of the exception message. */
    private String message;

    /**
     * Public default constructor.
     */
    public DaoException() {

        super();

    }

    /**
     * Public initialize constructor.
     *
     * @param newMessage new value of the exception message
     */
    public DaoException(final String newMessage) {

        super(newMessage);

        this.message = newMessage;

    }

    /**
     * Public initialize constructor.
     *
     * @param throwable new value of the object Throwable
     */
    public DaoException(final Throwable throwable) {

        super(throwable);

    }

    /**
     * Public initialize constructor.
     *
     * @param newMessage new value of the exception message
     * @param throwable  new value of the object Throwable
     */
    public DaoException(final String newMessage,
                                final Throwable throwable) {

        super(newMessage, throwable);

    }

    /**
     * This method return value of the exception message.
     *
     * @return value of the exception message
     * */
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
