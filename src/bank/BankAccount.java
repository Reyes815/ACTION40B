package bank;

import java.util.List;

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
     * @return boolean value if bank account is frozen
     */
    boolean isFrozen();
    /**
     * Used for transaction history and organization.
     * @return transaction list
     */
    List<Transaction> getTransactionHistory();

    // Please add freezeAccount and unfreezeAccount in Interface based on specs
    /**
     * freezes current bank account to stop any bank operations.
     */
    void freezeAccount();

    /**
     * Unfreezes current bank account to enable operations.
     */
    void unfreezeAccount();
}
