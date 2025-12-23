package bank;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import sample.Library.Book;
import sample.Library.BookRentalSystem;
import sample.Library.FictionBook;
import sample.Library.NonFictionBook;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SavingsAccountTest {
    /**
     * for checking of string output.
     */
    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();
    
    SavingsAccount newAcc = new SavingsAccount("mark");
    final double newDeposit = 500;
    final double negativeDeposit = -500;
    final double zeroDeposit = 0;
    final double newWithdraw = 100;
    final double negativeWithdraw = -100;
    final double overWithdraw = 600;

    @BeforeEach
    void setup() {
        newAcc.clearBalance();

        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }
    
    @Order(1)
    @DisplayName("Account Creation")
    @Test
    void testCreateNewAccount_NewAccountTest() {
        SavingsAccount newAcc = new SavingsAccount("test");
        System.out.println(newAcc.getOwnerName());
        
        String expectedOutput =
                "Bank Account under: test created."
                + System.lineSeparator()
                + "test";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(2)
    @DisplayName("Deposit Amount")
    @Test
    void testDepositAmount_SameBalance() {
        newAcc.deposit(newDeposit);
        
        String expectedOutput =
                "Deposit: Php 500.0.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(3)
    @DisplayName("Deposit Negative Amount")
    @Test
    void testDepositNegativeAmount_ErrorMessage() {
        newAcc.deposit(negativeDeposit);
        
        String expectedOutput =
                "The deposit amount must be positive";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(4)
    @DisplayName("Deposit 0 Amount")
    @Test
    void testDepositEmptyAmount_ErrorMessage() {
        newAcc.deposit(zeroDeposit);
        
        String expectedOutput =
                "The deposit amount must be positive";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(5)
    @DisplayName("Withdraw Amount with Suffiecient Funds")
    @Test
    void testWithdrawProperAmount_SuccessfulResponse() {
        newAcc.deposit(newDeposit);
        newAcc.withdraw(newWithdraw);
        
        String expectedOutput =
                "Deposit: Php 500.0."
                 + System.lineSeparator()
                 + "Withdrawn: Php 100.0.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(6)
    @DisplayName("Withdraw Amount with Insufficient Funds")
    @Test
    void testWtihdrawTooMuch_ErrorMessage() {
        newAcc.deposit(newDeposit);
        newAcc.withdraw(overWithdraw);
        
        String expectedOutput =
                "Deposit: Php " + newAcc.getBalance() + "."
                 + System.lineSeparator()
                 + "Insufficient balance.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(7)
    @DisplayName("Withdraw Negative Amount")
    @Test
    void testWithdrawNegative_ErrorMessage() {
        newAcc.deposit(newDeposit);
        newAcc.withdraw(negativeWithdraw);
        
        String expectedOutput =
                "Deposit: Php " + newAcc.getBalance() + "."
                 + System.lineSeparator()
                 + "The withdrawn amount must be positive.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }

    @Order(8)
    @DisplayName("Deposit When Account is Frozen")
    @Test
    void testDepositFromFrozenAccount_ErrorMessage() {
        newAcc.freezeAccount();
        newAcc.deposit(newDeposit);
        
        String expectedOutput =
                "Account has been frozen."
                + System.lineSeparator()
                + "Account is frozen."
                + System.lineSeparator()
                + "Cannot deposit.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Order(9)
    @DisplayName("Withdraw When Account is Frozen")
    @Test
    void testWithdrawWhenAccountFrozen_ErrorMessage() {
        newAcc.freezeAccount();
        newAcc.withdraw(newWithdraw);
        
        String expectedOutput =
                "Account has been frozen."
                + System.lineSeparator()
                + "Account is frozen."
                + System.lineSeparator()
                + "Cannot withdraw.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Order(10)
    @DisplayName("Unfreeze Account and Withdraw")
    @Test
    void testUnfreezeAccountThenWithdraw_SuccessfulTransactions() {
        newAcc.deposit(newDeposit);
        newAcc.freezeAccount();
        newAcc.unfreezeAccount();
        newAcc.withdraw(newWithdraw);
        
        String expectedOutput =
                "Deposit: Php 500.0."
                + System.lineSeparator()
                + "Account has been frozen."
                + System.lineSeparator()
                + "Account has been unfrozen."
                + System.lineSeparator()
                + "Withdrawn: Php 100.0.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Order(11)
    @DisplayName("Check Account is Frozen")
    @Test
    void testCheckFrozenAccount_true() {
        newAcc.freezeAccount();
        
        boolean actualOutput = newAcc.isFrozen();
        
        assertEquals(true,
                actualOutput,  "Output strings should match");
    }
    
    @Order(12)
    @DisplayName("Check Balance After Multiple Transactions")
    @Test
    void testCheckBalance_SuccessfulTransactions() {
        newAcc.deposit(newDeposit); //500
        newAcc.withdraw(newWithdraw); //-100
        newAcc.deposit(newDeposit); //500
        newAcc.withdraw(newWithdraw); //-100

        assertEquals(800.0,
                newAcc.getBalance(),  "Balance should match");
    }
}
