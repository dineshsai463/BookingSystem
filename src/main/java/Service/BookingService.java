package Service;



import model.Booking;

import java.util.List;
import java.util.Map;

public interface BookingService {
    void addBooking(String username, String movie, Integer[] seats);
    Booking getBooking(String username);
    Map<String, Booking> getAllBookings();
    List<Integer> getAvailableSeats(String movie);
}
