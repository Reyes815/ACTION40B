package movie;

import java.util.Scanner;

public class MovieBookingSystem extends BookingSystem {
    /**
     * globalScanner to close whenever used.
     */
    private Scanner globalScanner = new Scanner(System.in);
    /**
     * @return global scanner.
     */
    public Scanner getGlobalScanner() {
        return globalScanner;
    }
    /**
     * Available Tickets for ticketsAvailable array.
     */
    private final int tixAvailableEntry = 5;
    /**
     * reservationArray used for movie reservation.
     */
    private String[] reservationArray = new String[] {"10:00 AM", "1:00 PM"};
    /**
     * ticketsAvailable used for managing tickets.
     */
    private int[] ticketsAvailable =
            new int[] {tixAvailableEntry, tixAvailableEntry};
    /**
     * ticketsBooked used for managing booked tickets.
     */
    private int[] ticketsBooked =
            new int[] {0, 0};
    /**
    *
    * @param newTime check current time
    * @return tickets return available tickets
    */
   public int checkAvailability(final String newTime) {
       for (int i = 0; i < reservationArray.length; i++) {
           if (reservationArray[i].equals(newTime)) {
               return i;
           }
       }
       return -1;
   }
   /**
    *
    * @param newTime movie time input the user wants to book
    * @param newTickets movie tickets the user wants to book
    */
   public void bookTicket(final String newTime, final int newTickets) {
       if (checkAvailability(newTime) == -1) {
           System.out.println("Time slot does not exist.");
           return;
       }

       for (int i = 0; i < reservationArray.length; i++) {
           if (reservationArray[i].equals(newTime)) {
               if (ticketsAvailable[i] >= newTickets) {
                   ticketsAvailable[i] -= newTickets;
                   ticketsBooked[i] = newTickets;
                   System.out.println(newTickets + " tickets successfully "
                           + "booked for " + reservationArray[i]);
               } else {
                   System.out.println("Not enough tickets "
                           + "available for this showtime");
               }
           }
       }
   }
   /**
    *
    * @param newTime movie time input the user wants to remove
    * @param newTickets the tickets the user wants to cancel
    * @param sc for scanning.
    */
   public void cancelReservation(final String newTime,
           final int newTickets, final Scanner sc) {
       if (checkAvailability(newTime) == -1) {
           System.out.println("Time slot does not exist.");
           return;
       }
       System.out.println("Do you wish to proceed? [Y][N]");
       String input = sc.next();

       if (!input.equals("Y") && !input.equals("N")) {
           System.out.println("Invalid Input");
           return;
       }

       if (input.equals("N")) {
           return;
       }

       for (int i = 0; i < reservationArray.length; i++) {
           if (reservationArray[i].equals(newTime)) {
               if (ticketsBooked[i] >= newTickets) {
                 ticketsAvailable[i] += newTickets;
                 ticketsBooked[i] -= newTickets;
                 System.out.println(newTickets + " tickets successfully "
                         + "canceled for " + reservationArray[i]);
               } else {
                   System.out.println("Invalid operation "
                           + "(Attempt to cancel more tickets than booked)");
               }
           }
       }
   }
   /**
    * shows the current time slots and their perspective tickets available.
    */
   public void showTickets() {
       System.out.println("Shows and Tickets Available");
       for (int i = 0; i < reservationArray.length; i++) {
           System.out.println(reservationArray[i]
           + ": " + ticketsAvailable[i] + " tickets available.");
       }
   }
   /**
    *
    * @param args
    */
   public static void main(final String[] args) {
       final int validTicket = 5;
       final int invalidTickets = 100;
       final int cancelTicket = 3;
       final int validTicket2 = 2;
       final int invalidCancelTickets = 5;
       MovieBookingSystem newSystem = new MovieBookingSystem();
       newSystem.bookTicket("10:00 AM", validTicket);
       newSystem.bookTicket("10:00 AM", invalidTickets);
       newSystem.cancelReservation("10:00 AM",
               cancelTicket, newSystem.getGlobalScanner());
       newSystem.bookTicket("1:00 PM", validTicket2);
       newSystem.cancelReservation("1:00 PM",
               invalidCancelTickets, newSystem.getGlobalScanner());
       newSystem.showTickets();
   }
}
