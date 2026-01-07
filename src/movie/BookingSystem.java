package movie;

public abstract class BookingSystem {
    // Additional information about these abstract

    /**
     * checks the current show time lists if newTime is available or not.
     * @param newTime  - current time slot the user is checking
     * @return int     - returns the current index of the time slot
     */
    public int checkAvailability(final String newTime) {
        return 0;
    }
    /**
     * Books tickets for a show using the newTime and newTickets parameters.
     * @param newTime    - current time slot the user wants to book.
     * @param newTickets - the number of tickets the user wants to book.
     */
    public void bookTicket(final String newTime, final int newTickets) {
    }
    /**
     * Cancels the tickets bought for a time slot.
     * @param newTime    - current time slot the user wants to cancel.
     * @param newTickets - the number of tickets the user wants refunded.
     */
    public void cancelReservation(final String newTime, final int newTickets) {
    }
}
