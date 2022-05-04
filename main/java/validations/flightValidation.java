package validations;

import generator.Flight;
import generator.booking;
import design1.Seats;

import java.util.List;
import java.util.Map;

public class flightValidation {
    private final booking booking;
    public Map<String, List<Flight>> Map1;

    public flightValidation(booking booking, Map<String, List<Flight>> Map1) {
        this.booking = booking;
        this.Map1 = Map1;
    }

    public boolean existingFlight(){
        String orderFlightNum = booking.getAirCode();
        if (orderFlightNum == null || orderFlightNum.length() == 0) {
            return false;
        }

        for(String flightNum : Map1.keySet()) {
            if (orderFlightNum.equals(flightNum)) {
                return true;
            }
        }

        return false;
    }

    public boolean availableSeats() {
        int orderSeats = Integer.parseInt(booking.getSeatAvailability());
        String category = booking.getsCat();
        String flightNum = booking.getAirCode();

        for(Map.Entry<String, List<Flight>> flight : Map1.entrySet()) {
            List<Flight> oneFlight = flight.getValue();
            for(Flight curFlight : oneFlight) {
                if (category.equals(curFlight.getCat()) && flightNum.equals(curFlight.getAirlineCode()) && orderSeats <= curFlight.getSeatAvailability()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void changeOfSeat() {
        Seats Seats = new Seats(Map1);
        Seats.setSeatMap();
        Seats.modifySeat(booking.getsCat(), booking.getSeatAvailability(), booking.getAirCode());
    }


}
