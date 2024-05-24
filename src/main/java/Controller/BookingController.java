package Controller;




import model.Booking;
import Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import  org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        Booking booking = bookingService.getBooking(username);
        model.addAttribute("bookedSeats", booking != null ? booking.getSeats() : null);
        model.addAttribute("allBookings", bookingService.getAllBookings());
        return "movieSelection";
    }

    @PostMapping("/book")
    public String book(@RequestParam String username, @RequestParam String movie, @RequestParam String seats, Model model) {
        Integer[] seatNumbers = parseSeats(seats);
        bookingService.addBooking(username, movie, seatNumbers);
        return "redirect:/login?username=" + username;
    }

    @GetMapping("/movieSelection")
    public String movieSelection(@RequestParam String username, @RequestParam String movie, Model model) {
        Booking booking = bookingService.getBooking(username);
        model.addAttribute("username", username);
        model.addAttribute("bookedSeats", booking != null && booking.getMovie().equals(movie) ? booking.getSeats() : null);
        model.addAttribute("availableSeats", bookingService.getAvailableSeats(movie));
        return "movieSelection";
    }

    private Integer[] parseSeats(String seats) {
        String[] seatStrings = seats.split(",");
        Integer[] seatNumbers = new Integer[seatStrings.length];
        for (int i = 0; i < seatStrings.length; i++) {
            seatNumbers[i] = Integer.parseInt(seatStrings[i].trim());
        }
        return seatNumbers;
    }
}
