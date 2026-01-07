package bank;

public abstract class AbstractBankAccount implements BankAccount {
    /**
     * current balance amount.
     */
    private double balance;
    /**
     * check if account is frozen.
     */
    private boolean isFrozen;

    AbstractBankAccount() {
        this.balance = 0;
        this.isFrozen = false;
    }

    /**
     * freezes bank account.
     */
    public final void freezeAccount() {
        this.isFrozen = true;
        System.out.println("Account has been frozen.");
    }

    /**
     * set isFrozen to false.
     */
    public final void unfreezeAccount() {
        this.isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }

    @Override
    public final void deposit(final double amount) {
        if (!this.isFrozen) {
            if (amount <= 0) {
                System.out.println("The deposit amount must be positive");
            } else {
                this.balance = this.getBalance() + amount;
                System.out.println("Deposit: Php " + this.getBalance() + ".");
            }
        } else {
            System.out.println("Account is frozen.");
            System.out.println("Cannot deposit.");
        }
    }

    @Override
    public final void withdraw(final double amount) {
        if (!this.isFrozen) {
            if (amount <= 0) {
                System.out.println("The withdrawn amount must be positive.");
            } else if (this.getBalance() < amount) {
                System.out.println("Insufficient balance.");
            } else {
                this.balance = this.getBalance() - amount;
                System.out.println("Withdrawn: Php " + amount + ".");
            }
        } else {
            System.out.println("Account is frozen.");
            System.out.println("Cannot withdraw.");
        }
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
     * for testing purposes.
     */
    public final void clearBalance() {
        this.balance = 0;
    }

}
