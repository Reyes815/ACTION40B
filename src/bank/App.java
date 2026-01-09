package bank;

import java.util.List;

public final class App {
    private App() {
    }

    // Please elaborate Javadoc
    /**
     * main function used for simulation on bank operations.
     * @param args does nothing
     */
    public static void main(final String... args) {
        SavingsAccount newAcc = new SavingsAccount("mark");
        BankAccountManager manager = new BankAccountManager();
        manager.addAccount(newAcc); //tc1
        System.out.println("//---------------------------//");

        final double newDeposit = 1000;
        newAcc.deposit(newDeposit); //tc2
        System.out.println("//---------------------------//");

        try {
            final double zeroDeposit = 0;
            newAcc.deposit(zeroDeposit); //tc3
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }

        try {
            final double negativeDeposit = -500;
            newAcc.deposit(negativeDeposit); //tc4
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }

        final double fiveHundred = 500;
        newAcc.withdraw(fiveHundred); //tc5
        System.out.println("//---------------------------//");

        try {
            final double overWithdraw = 1500;
            newAcc.withdraw(overWithdraw); //tc6
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }

        try {
            final double negativeWithdraw = -100;
            newAcc.withdraw(negativeWithdraw); //tc7
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }

        try {
            newAcc.freezeAccount(); //tc8
            newAcc.deposit(newDeposit); //tc8
            System.out.println("//---------------------------//");
        } catch (AccountFrozenException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }

        try {
            newAcc.freezeAccount(); //tc9
            newAcc.withdraw(fiveHundred); //tc9
        } catch (AccountFrozenException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }

        final double secWithdraw = 100;
        newAcc.unfreezeAccount(); //tc10
        newAcc.withdraw(secWithdraw); //tc10
        System.out.println("//---------------------------//");

        System.out.println(newAcc.getBalance()); //tc11
        System.out.println("//---------------------------//");

        List<Transaction> history = newAcc.getTransactionHistory();
        System.out.println(manager
                .filterTransactionsAbove(fiveHundred, history)); //tc12
        System.out.println("//---------------------------//");

        try {
            System.out.println(manager
                    .filterTransactionsAbove(0, history));
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }
        try {
            System.out.println(manager
                    .filterTransactionsAbove(-1, history));
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("//---------------------------//");
        }

        manager.sortTransactionsByAmount(history); //tc13
        history.forEach(System.out::println);
        System.out.println("//---------------------------//");

        try {
            manager.getAccount(2); //tc14
            System.out.println("//---------------------------//");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
