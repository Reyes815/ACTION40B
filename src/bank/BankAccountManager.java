package bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankAccountManager {
    /**
     * Transaction storage/organizer for all transactions done.
     */
    private Map<Integer, BankAccount> accounts;
    /**
     * Integer index for mapping.
     */
    private int id;
    BankAccountManager() {
        accounts = new HashMap<Integer, BankAccount>();
        id = 1;
    }
    /**
     * Add an account into the hash map and increments the current index.
     * @param account new account being added.
     */
    public void addAccount(final BankAccount account) {
        this.accounts.put(this.id, account);
        System.out.println("Account ID: " + this.id
                + " Balance: " + account.getBalance());
        this.id++;
    }
    /**
     * returns the current bank account using account id.
     * @param accountID
     * @return bank account
     */
    public BankAccount getAccount(final int accountID) {
        if (accounts.get(accountID) == null) {
            throw new NullPointerException(
                    "User at " + accountID + " does not exist.");
        }
        return this.accounts.get(accountID);
    }
    /**
     * prints out the list of all accounts with their user ID and account.
     */
    // cover in JUnit
    public void listAccounts() {
        accounts.forEach((userID, userAcc) -> {
            System.out.println("ID: " + userID + " User: " + userAcc);
        });
    }
    /**
     * Returns all transactions with amounts greater than amount given.
     * @param amount used for filtering
     * @param txList used for organization and output
     * @return filter list of transactions
     */
    public List<Transaction> filterTransactionsAbove(
            final double amount, final List<Transaction> txList) {
        if (amount == 0) {
            throw new InvalidAmountException(
                    "Cannot use 0 as an amount.");
        }
        if (amount < 0) {
            throw new InvalidAmountException(
                    "Cannot use a negative amount.");
        }

        return txList.stream()
                .filter(x -> x.getAmount() >= amount)
                .collect(Collectors.toList());
    }
    /**
     * Compares the values of Transactions
     * x and y and sorts them accordingly.
     * @param txList
     */
    public void sortTransactionsByAmount(final List<Transaction> txList) {
        txList.sort((x, y) -> Double.compare(x.getAmount(), y.getAmount()));
    }
}
