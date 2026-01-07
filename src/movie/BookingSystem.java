package movie;

public abstract class BookingSystem {
    /**
     *
     * @param newTime
     * @return tickets
     */
    public int checkAvailability(final String newTime) {
        return 0;
    }
    /**
     *
     * @param newTime
     * @param newTickets
     */
    public void bookTicket(final String newTime, final int newTickets) {
    }
    /**
     *
     * @param newTime
     * @param newTickets
     */
    public void cancelReservation(final String newTime, final int newTickets) {
    }
}
