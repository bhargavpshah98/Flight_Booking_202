package generator;

import java.util.ArrayList;
import java.util.List;

public class bookingInit {
    private List<String[]> bookings;
    private List<booking> bookings1;

    public bookingInit(List<String[]> bookings) {
        this.bookings = bookings;
        this.bookings1 = new ArrayList<>();
    }
    public List<booking> generateList() {
        for (String[] record : bookings) {
            String bookingName = record[0];
            String flightNumber = record[1];
            String seatCategory = record[2];
            String numberOfSeats = record[3];
            String card = record[4];
            booking booking = new booking(bookingName, flightNumber, seatCategory, numberOfSeats, card);
            this.bookings1.add(booking);
        }
        return bookings1;
    }
    public List<String[]> getBookings() {
        return bookings;
    }

    public void setBookings(List<String[]> bookings) {
        this.bookings = bookings;
    }

    public List<booking> getOrderList() {
        return bookings1;
    }

    public void setOrderList(List<booking> bookingList) {
        this.bookings1 = bookingList;
    }
}
