package sample;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LeapYearTest {

    @Order(1)
    @DisplayName("Divisible by 400")
    @Test
    void isLeapYearDivisibleByFourHundredReturnsTrue() {
        final int divby400 = 400;
        LeapYear test1 = new LeapYear(divby400);

        //Act
        boolean result = test1.isLeapYear();

        //Assert
        assertEquals(result, true,
                () -> test1.getYear() + " is a leap year");
    }

    @Order(2)
    @DisplayName("Divisible by 100 but not 400")
    @Test
    void isLeapYearDivisibleByOneHundredNotFourHundredReturnsFalse() {
        final int divby100not400 = 1500;
        LeapYear test1 = new LeapYear(divby100not400);

        //Act
        boolean result = test1.isLeapYear();

        //Assert
        assertEquals(result, false,
                () -> test1.getYear() + " is not a leap year");
    }

    @Order(3)
    @DisplayName("Divisible by 4 but not 100")
    @Test
    void isLeapYearDivisibleByFourNotOneHundredReturnsTrue() {
        final int divby4not100 = 1604;
        LeapYear test1 = new LeapYear(divby4not100);

        //Act
        boolean result = test1.isLeapYear();

        //Assert
        assertEquals(result, true,
                () -> test1.getYear() + " is a leap year");
    }

    @Order(4)
    @DisplayName("Not divisible by 4")
    @Test
    void isLeapYearDivisibleByFourReturnsFalse() {
        final int notdivby400 = 1500;
        LeapYear test1 = new LeapYear(notdivby400);

        //Act
        boolean result = test1.isLeapYear();

        //Assert
        assertEquals(result, false,
                () -> test1.getYear() + " is not a leap year");
    }

    @Order(5)
    @DisplayName("Random Leap Year")
    @Test
    void isLeapYearDivisibleByRandomLeapYearReturnsTrue() {
        final int randomLeapYear = 2020;
        LeapYear test1 = new LeapYear(randomLeapYear);

        //Act
        boolean result = test1.isLeapYear();

        //Assert
        assertEquals(result, true,
                () -> test1.getYear() + " is a leap year");
    }

    @Order(6)
    @DisplayName("Random Non Leap Year")
    @Test
    void isLeapYearDivisibleByRandomNonLeapYearReturnsFalse() {
        final int randomNonLeapYear = 2023;
        LeapYear test1 = new LeapYear(randomNonLeapYear);

        //Act
        boolean result = test1.isLeapYear();

        //Assert
        assertEquals(result, false,
                () -> test1.getYear() + " is not a leap year");
    }

}
