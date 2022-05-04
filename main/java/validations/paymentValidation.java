package validations;

import generator.Flight;
import generator.booking;
import design1.Cards;
import design1.Prices;

import java.util.List;
import java.util.Map;

public class paymentValidation {
    private booking booking;
    public Map<String, List<Flight>> flights;

    public paymentValidation(booking booking, Map<String, List<Flight>> flights) {
        this.booking = booking;
        this.flights = flights;
    }

    public boolean validationOfCard() {
        Cards Cards = new Cards(booking.getCard());
        return Cards.cardValid();
    }

    public int totalPrice() {
        int numOfGuests = Integer.parseInt(booking.getSeatAvailability());
        Prices Prices = new Prices(flights);
        Prices.setPriceMap();
        int seatPrice = Prices.getPrice(booking.getsCat().replaceAll("\\s", ""), booking.getAirCode());
        return numOfGuests * seatPrice;
    }

}

