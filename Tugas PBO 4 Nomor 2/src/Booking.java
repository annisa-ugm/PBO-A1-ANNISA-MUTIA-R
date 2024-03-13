public class Booking {
    private int bookingId;
    private Film film;
    private int numberOfTickets;

    public Booking(int bookingId, Film film, int numberOfTickets) {
        this.bookingId = bookingId;
        this.film = film;
        this.numberOfTickets = numberOfTickets;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Film getFilm() {
        return film;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
