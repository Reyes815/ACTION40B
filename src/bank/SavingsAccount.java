package bank;

public class SavingsAccount extends AbstractBankAccount {
    /**
     *
     */
    private String ownerName;

    /**
     * Default constructor for Savings Account.
     * @param name - Savings Account user name.
     */
    SavingsAccount(final String name) {
        System.out.println("Bank Account under: " + name + " created.");
        this.ownerName = name;
    }

    /**
     * @return ownerName gets the current bank account owners name.
     */
    // Cover in JUnit
    public String getOwnerName() {
        return ownerName;
    }
}
