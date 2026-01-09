package bank;

@SuppressWarnings("serial")
public class InsufficientFundsException extends RuntimeException {
    /**
     * Exception for handling withdrawals that
     * exceed the user's current balance.
     * @param message
     */
    public InsufficientFundsException(final String message) {
        super(message);
    }
}

@SuppressWarnings("serial")
class InvalidAmountException extends RuntimeException {
    /**
     * Exception for handling negative values that
     * are being withdrawn or deposited.
     * @param message
     */
    InvalidAmountException(final String message) {
        super(message);
    }
}

@SuppressWarnings("serial")
class AccountFrozenException extends RuntimeException {
    /**
     * Exception for handling transactions on frozen accounts.
     * @param message
     */
    AccountFrozenException(final String message) {
        super(message);
    }
}
