package bank;

public interface BankAccount {
    /**
     *
     * @param amount - deposit to bank
     */
    void deposit(double amount);
    /**
     *
     * @param amount - withdraw amount
     */
    void withdraw(double amount);
    /**
     *
     * @return the current balance
     */
    double getBalance();
    /**
     *
     * @return boolean value
     */
    boolean isFrozen();
}
