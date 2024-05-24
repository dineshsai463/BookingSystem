package model;



import java.util.Arrays;

public class Booking {
    private String username;
    private String movie;
    private Integer[] seats;

    public Booking(String username, String movie, Integer[] seats) {
        this.username = username;
        this.movie = movie;
        this.seats = seats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Integer[] getSeats() {
        return seats;
    }

    public void setSeats(Integer[] seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "username='" + username + '\'' +
                ", movie='" + movie + '\'' +
                ", seats=" + Arrays.toString(seats) +
                '}';
    }
}
