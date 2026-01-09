package bank;

import java.util.List;

public final class App {
    private App() {
    }
    /**
     * main function.
     * @param args does nothing
     */
    public static void main(final String... args) {
        final double newDeposit = 1000;
        final double negativeDeposit = -500;
        final double zeroDeposit = 0;
        final double fiveHundred = 500;
        final double secWithdraw = 100;
        final double negativeWithdraw = -100;
        final double overWithdraw = 1500;

        SavingsAccount newAcc = new SavingsAccount("mark");
        BankAccountManager kenSama = new BankAccountManager();
        kenSama.addAccount(newAcc); //tc1
        newAcc.deposit(newDeposit); //tc2
        try {
            newAcc.deposit(zeroDeposit); //tc3
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
        try {
            newAcc.deposit(negativeDeposit); //tc4
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
        newAcc.withdraw(fiveHundred); //tc5
        try {
            newAcc.withdraw(overWithdraw); //tc6
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            newAcc.withdraw(negativeWithdraw); //tc7
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
        try {
            newAcc.freezeAccount(); //tc8
            newAcc.deposit(newDeposit); //tc8
        } catch (AccountFrozenException e) {
            System.out.println(e.getMessage());
        }
        try {
            newAcc.freezeAccount(); //tc9
            newAcc.withdraw(fiveHundred); //tc9
        } catch (AccountFrozenException e) {
            System.out.println(e.getMessage());
        }
        newAcc.unfreezeAccount(); //tc10
        newAcc.withdraw(secWithdraw); //tc10
        System.out.println(newAcc.getBalance()); //tc11
        List<Transaction> history = newAcc.getTransactionHistory();
        System.out.println(kenSama
                .filterTransactionsAbove(fiveHundred, history)); //tc12
        kenSama.sortTransactionsByAmount(history); //tc13
        history.forEach(System.out::println);
        try {
            kenSama.getAccount(2); //tc14
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
