package Service;

import  model.Booking;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {
    private Map<String, Booking> bookings = new HashMap<>();
    private Map<String, List<Integer>> movieSeats = new HashMap<>();

    public BookingServiceImpl() {
        // Initialize available seats for each movie (1 to 10)
        movieSeats.put("Movie 1", new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        movieSeats.put("Movie 2", new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Override
    public void addBooking(String username, String movie, Integer[] seats) {
        bookings.put(username, new Booking(username, movie, seats));
        List<Integer> availableSeats = movieSeats.get(movie);
        availableSeats.removeAll(Arrays.asList(seats));
    }

    @Override
    public Booking getBooking(String username) {
        return bookings.get(username);
    }

    @Override
    public Map<String, Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public List<Integer> getAvailableSeats(String movie) {
        return movieSeats.get(movie);
    }
}

