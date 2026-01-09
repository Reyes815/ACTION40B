package bank;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    
    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();
    SavingsAccount newAcc = new SavingsAccount("mark");
    BankAccountManager manager = new BankAccountManager();
    
    @BeforeEach
    void setup() {
        newAcc.clearBalance();
        newAcc.unfreezeAccount();
        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    void checkAccount_DisplayAccountIDWithBalane_ValidMessage() {
        manager.addAccount(newAcc); //tc1
        
        String expectedOutput =
                "Account ID: 1 Balance: 0.0";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }
    
    @Test
    void checkOwner_CallGetOwnerNameFunction_ValidMessage() {
        System.out.println(newAcc.getOwnerName());
        
        String expectedOutput = "mark";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }
    
    @Test
    void checkDeposit_DepositValidAmount_ValidMessage() {
        newAcc.deposit(1000); //tc2
        
        String expectedOutput =
                "Deposit: Php 1000.0.";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }
    
    @Test
    void checkZeroDeposit_DepositZero_ErrorMessage() {
        InvalidAmountException thrown = assertThrows(
                InvalidAmountException.class,
                () -> newAcc.deposit(0), //tc3
                "Deposited zero amount triggers invalid amount exception"
         );
         assertTrue(thrown.getMessage().contains("Deposit with zero amount."));
    }
    
    @Test
    void checkNegativeDeposit_DepositBelowZero_ErrorMessage() {
        InvalidAmountException thrown = assertThrows(
                InvalidAmountException.class,
                () -> newAcc.deposit(-1), //tc4
                "Deposited negative amount triggers invalid amount exception"
         );
         assertTrue(thrown.getMessage().contains("Deposit with negative amount."));
    }
    
    @Test
    void checkWithdraw_DisplayWithdraw_ValidMessage() {
        newAcc.deposit(1000);
        newAcc.withdraw(500); //tc5
        
        String expectedOutput =
                "Withdrawn: Php 500.0.";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }
    
    @Test
    void checkWithdraw_WithdrawOverAmount_ErrorMessage() {
        InsufficientFundsException thrown = assertThrows(
                InsufficientFundsException.class,
                () -> newAcc.withdraw(1000), //tc6
                "Deposited zero amount triggers invalid amount exception"
         );
         assertTrue(thrown.getMessage().contains("Withdraw with insufficient funds."));
    }
    
    @Test
    void checkWithdraw_WithdrawNegativeAmount_ErrorMessage() {
        InvalidAmountException thrown = assertThrows(
                InvalidAmountException.class,
                () -> newAcc.withdraw(-1), //tc7
                "Deposited zero amount triggers invalid amount exception"
         );
         assertTrue(thrown.getMessage().contains("Withdraw with negative amount."));
    }
    
    @Test
    void checkFrozenAccount_DepositToFrozenAccount_ErrorMessage() {
        newAcc.freezeAccount();
        AccountFrozenException thrown = assertThrows(
                AccountFrozenException.class,
                () -> newAcc.deposit(500), //tc8
                "Deposited zero amount triggers invalid amount exception"
         );
         assertTrue(thrown.getMessage().contains("Deposit when account is frozen."));
    }
    
    @Test
    void checkFrozenAccount_WithdrawFromFrozenAccount_ErrorMessage() {
        newAcc.deposit(1000);
        newAcc.freezeAccount();
        AccountFrozenException thrown = assertThrows(
                AccountFrozenException.class,
                () -> newAcc.withdraw(500), //tc9
                "Deposited zero amount triggers invalid amount exception"
         );
         assertTrue(thrown.getMessage().contains("Withdraw when account is frozen."));
    }
    
    @Test
    void checkUnfreeze_UnfreezeAccount_ValidMessage() {
        newAcc.deposit(500);
        newAcc.freezeAccount();
        newAcc.unfreezeAccount();
        newAcc.withdraw(100); //tc10
        
        String expectedOutput =
                "Account has been unfrozen."
                + System.lineSeparator()
                + "Withdrawn: Php 100.0.";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }
    
    @Test
    void checkBalance_UseGetBalanceFunctions_ValidMessage() {
        newAcc.deposit(500);
        System.out.println(newAcc.getBalance()); //tc11
        
        String expectedOutput =
                "500.0";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    void checkHistory_DisplayTransactionHistoryWithFilter_ValidMessage() {
        newAcc.deposit(1000);
        newAcc.deposit(500);
        newAcc.withdraw(500);
        List<Transaction> history = newAcc.getTransactionHistory();
        System.out.println(manager
              .filterTransactionsAbove(500, history)); //tc12
        
        String expectedOutput =
                "[Deposit: Php1000.0., Deposit: Php500.0., Withdraw: Php500.0.]";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }
    
    @Test
    void checkHistory_DisplayTransactionHistoryWithZeroAsFilter_ErrorMessage() {
        newAcc.deposit(1000);
        newAcc.deposit(500);
        newAcc.withdraw(500);
        List<Transaction> history = newAcc.getTransactionHistory();
        Exception thrown = assertThrows(
                Exception.class,
                () -> System.out.println(manager
                        .filterTransactionsAbove(0, history)),
                "Non-existent Account"
         );
         assertTrue(thrown.getMessage().contains("Cannot use 0 as an amount."));
    }
    
    @Test
    void checkHistory_DisplayTransactionHistoryWithNegativeAsFilter_ErrorMessage() {
        newAcc.deposit(1000);
        newAcc.deposit(500);
        newAcc.withdraw(500);
        List<Transaction> history = newAcc.getTransactionHistory();
        Exception thrown = assertThrows(
                Exception.class,
                () -> System.out.println(manager
                        .filterTransactionsAbove(-1, history)),
                "Non-existent Account"
         );
         assertTrue(thrown.getMessage().contains("Cannot use a negative amount."));
    }
    
    @Test
    void checkHistory_DisplayTransactionHistoryByAmount_ValidMessage() {
        newAcc.deposit(1000);
        newAcc.deposit(500);
        newAcc.withdraw(400);
        List<Transaction> history = newAcc.getTransactionHistory();
        manager.sortTransactionsByAmount(history); //tc13
        history.forEach(System.out::println);
        
        String expectedOutput =
                "Withdraw: Php400.0."
                + System.lineSeparator()
                + "Deposit: Php500.0."
                + System.lineSeparator()
                + "Deposit: Php1000.0.";
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains(expectedOutput));
    }
    
    @Test
    void checkNullPointer_GetInvalidAccount_ErrorMessage() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> manager.getAccount(2), //tc14
                "Non-existent Account"
         );
         assertTrue(thrown.getMessage().contains("User at 2 does not exist."));
    }
    
    @Test
    void checkmain() {
        App.main(null);
    }
}
