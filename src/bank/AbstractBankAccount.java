package bank;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBankAccount implements BankAccount {
    /**
     * current balance amount.
     */
    private double balance;
    /**
     * check if account is frozen.
     */
    private boolean isFrozen;
    /**
     * transaction list.
     */
    private List<Transaction> transactionHistory;

    // Add javadoc for constructor
    /**
     * Initializes a new BankAccount with zero balance, unfrozen status
     * and a transaction history for storage.
     */
    AbstractBankAccount() {
        this.balance = 0;
        this.isFrozen = false;
        this.transactionHistory = new ArrayList<Transaction>();
        // Constructor should initialize transactionHistory as an ArrayList
    }

    @Override
    public final void freezeAccount() {
        this.isFrozen = true;
        System.out.println("Account has been frozen.");
    }

    @Override
    public final void unfreezeAccount() {
        this.isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }

    @Override
    public final void deposit(final double amount) {
        if (!this.isFrozen) {
            if (amount == 0) {
                throw new InvalidAmountException(
                        "Deposit with zero amount.");
            } else if (amount < 0) {
                throw new InvalidAmountException(
                        "Deposit with negative amount.");
            } else {
                this.balance = this.getBalance() + amount;
                Transaction transac =
                        new Transaction("Deposit", amount);
                transactionHistory.add(transac);
                System.out.println("Deposit: Php " + this.getBalance() + ".");
            }
        } else {
            throw new AccountFrozenException("Deposit when account is frozen.");
        }
    }

    @Override
    public final void withdraw(final double amount) {
        if (!this.isFrozen) {
            // Please cover if statement in JUnit
            if (amount == 0) {
                throw new InvalidAmountException(
                        "Withdraw with zero amount.");
            } else if (amount < 0) {
                throw new InvalidAmountException(
                        "Withdraw with negative amount.");
            } else if (this.getBalance() < amount) {
                throw new InsufficientFundsException(
                        "Withdraw with insufficient funds.");
            } else {
                this.balance = this.getBalance() - amount;
                Transaction transac =
                        new Transaction("Withdraw", amount);
                transactionHistory.add(transac);
                System.out.println("Withdrawn: Php " + amount + ".");
            }
        } else {
            throw new AccountFrozenException(
                    "Withdraw when account is frozen.");
        }
    }

    @Override
    public final List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }

    @Override
    public final double getBalance() {
        return this.balance;
    }

    @Override
    public final boolean isFrozen() {
        return this.isFrozen;
    }

    /**
     * Clear user balance on bank account.
     */
    public final void clearBalance() {
        this.balance = 0;
    }

}
