package bank;

public class SavingsAccount extends AbstractBankAccount {
    /**
     *
     */
    private String ownerName;

    /**
     *
     * @param name
     */
    SavingsAccount(final String name) {
        System.out.println("Bank Account under: " + name + " created.");
        this.ownerName = name;
    }

    /**
     *
     * @return gets the bank account owners name.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        final double newDeposit = 1000;
        final double negativeDeposit = -500;
        final double zeroDeposit = 0;
        final double newWithdraw = 500;
        final double negativeWithdraw = -100;
        final double overWithdraw = 1500;
        SavingsAccount newAcc = new SavingsAccount("mark");
        System.out.println(newAcc.getOwnerName());
        newAcc.deposit(newDeposit);
        newAcc.deposit(negativeDeposit);
        newAcc.deposit(zeroDeposit);
        newAcc.withdraw(newWithdraw);
        newAcc.withdraw(overWithdraw);
        newAcc.withdraw(negativeWithdraw);
        newAcc.freezeAccount();
        newAcc.deposit(newDeposit);
        newAcc.withdraw(newWithdraw);
        newAcc.unfreezeAccount();
        newAcc.withdraw(newWithdraw);
        System.out.println(newAcc.isFrozen());
        System.out.println("Balance: Php " + newAcc.getBalance());
    }
}
