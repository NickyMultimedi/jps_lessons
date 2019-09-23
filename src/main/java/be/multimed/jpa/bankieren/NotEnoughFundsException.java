package be.multimed.jpa.bankieren;

public class NotEnoughFundsException extends Exception {
    public NotEnoughFundsException() {
        super();
    }

    public NotEnoughFundsException(String message) {
        super(message);
    }

    public NotEnoughFundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughFundsException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughFundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
