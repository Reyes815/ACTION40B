package movie;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieBookingSystemTest {
    /**
     * for checking of string output.
     */
    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    MovieBookingSystem newSystem = new MovieBookingSystem();
    final int validTicket = 5;
    final int invalidTickets = 100;
    final int cancelTicket = 3;
    final int validTicket2 = 2;
    final int invalidCancelTickets = 5;
    private String[] reservationArray = new String[] {"10:00 AM", "1:00 PM"};
    private int[] ticketsAvailable;
    private int[] ticketsBooked;

    @BeforeEach
    void setup() {
        ticketsAvailable = new int[] {5, 5};
        ticketsBooked = new int[] {0, 0, 0, 0, 0};

        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
    }
    
    @Test
    void validTickets_ValidBookTickets_SuccessMessage() {
        newSystem.bookTicket("10:00 AM", 5);
        
        String expectedOutput =
                "5 tickets successfully booked for 10:00 AM";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Test
    void invalidTicketAmount_BookMoreTicketsThanAvailable_FailMessage() {
        newSystem.bookTicket("10:00 AM", 100);
        
        String expectedOutput =
                "Not enough tickets available for this showtime";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Test
    void cancelTickets_CancelTicketsFromAShow_SuccessMessage() {
        String simulatedInput = "Y" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sc = new Scanner(System.in);
        
        newSystem.bookTicket("10:00 AM", 5);
        newSystem.cancelReservation("10:00 AM", 3, sc);
        
        String expectedOutput =
                "5 tickets successfully booked for 10:00 AM"
                + System.lineSeparator() 
                + "Do you wish to proceed? [Y][N]"
                + System.lineSeparator() 
                + "3 tickets successfully canceled for 10:00 AM";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Test
    void validTickets2_ValidBookTicketsDiffShow_SuccessMessage() {
        newSystem.bookTicket("1:00 PM", 2);
        
        String expectedOutput =
                "2 tickets successfully booked for 1:00 PM";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Test
    void cancelTickets2_CancelTicketsDiffShow_FailMessage() {
        String simulatedInput = "Y" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        Scanner sc = new Scanner(System.in);
        
        newSystem.bookTicket("1:00 PM", 2);
        newSystem.cancelReservation("1:00 PM", 5, sc);
        
        String expectedOutput =
                "2 tickets successfully booked for 1:00 PM"
                + System.lineSeparator() +
                "Do you wish to proceed? [Y][N]"
                + System.lineSeparator() +
                "Invalid operation (Attempt to cancel more tickets than booked)";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Test
    void invalidTimeSlot_BookOnInvalidSlot_ErrorMessage() {
        newSystem.bookTicket("2:00 PM", 2);
        
        String expectedOutput =
                "Time slot does not exist.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
    
    @Test
    void invalidTimeSlot_CancelOnInvalidSlot_ErrorMessage() {
        String simulatedInput = "Y" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        Scanner sc = new Scanner(System.in);
        
        newSystem.cancelReservation("2:00 PM", 5, sc);
        
        String expectedOutput =
                "Time slot does not exist.";
        String actualOutput = outContent.toString().trim();
        
        assertEquals(expectedOutput,
                actualOutput,  "Output strings should match");
    }
}
