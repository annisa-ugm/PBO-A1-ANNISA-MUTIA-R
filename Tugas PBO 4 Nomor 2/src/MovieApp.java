import java.util.ArrayList;
import java.util.List;

public class MovieApp {
    private List<Film> films;
    private List<Booking> bookings;
    private int bookingIdCounter;

    public MovieApp() {
        this.films = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.bookingIdCounter = 1;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void displayAllFilms() {
        System.out.println("List of Films:");
        for (Film film : films) {
            System.out.println(film.getTitle() + " - " + film.getGenre() +
                    " - Duration: " + film.getDuration() + " mins - Available Seats: "
                    + film.getAvailableSeats());
        }
    }

    public void searchFilm(String title) {
        boolean found = false;
        for (Film film : films) {
            if (film.getTitle().equalsIgnoreCase(title)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Film Tersedia");
        } else {
            System.out.println("Film Tidak Tersedia");
        }
    }

    public void bookFilm(Film film, int numberOfTickets) {
        if (film.getAvailableSeats() >= numberOfTickets) {
            int bookingId = generateBookingId();
            bookings.add(new Booking(bookingId, film, numberOfTickets));
            film.setAvailableSeats(film.getAvailableSeats() - numberOfTickets);
            System.out.println("Pesanan berhasil dengan detail pesanan:");
            System.out.println("Film: " + film.getTitle());
            System.out.println("Jumlah Tiket: " + numberOfTickets);
            System.out.println("Booking ID: " + bookingId);

        } else {
            System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");

            displayAllFilms();
        }
    }

    private int generateBookingId() {
        return bookingIdCounter++;
    }

    public void searchBooking(int bookid) {
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookid) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Pesanan berhasil ditemukan");
        } else {
            System.out.println("Pesanan Tidak Ditemukan");
        }
    }
}