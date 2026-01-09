package bank;

public class Transaction {
    /**
     * current transaction type.
     */
    private final String type;
    /**
     * current transaction amount.
     */
    private final double amount;
    /**
     *  Default constructor for Transaction class.
     * @param transactionType - either withdraw or deposit
     * @param transactionAmount - current amount being moved.
     */
    Transaction(final String transactionType, final double transactionAmount) {
        this.type = transactionType;
        this.amount = transactionAmount;
    }
    /**
     * Public getter for private transaction type.
     * @return type from transaction
     */
    public String getType() {
        return type;
    }
    /**
     *  Public getter for private amount.
     * @return amount from transaction
     */
    public double getAmount() {
        return amount;
    }
    /**
     * returns a string value of the current transaction.
     * @return String
     */
    public String toString() {
        return getType() + ": Php" + getAmount() + ".";
    }
}
