package validations;

import generator.Flight;
import generator.booking;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class flightValidationTest {

    @Test
    public void flightExistTrue() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getAirlineCode(), new ArrayList<>());
        flightMap.get(flight.getAirlineCode()).add(flight);
        flightValidation flightValidation = new flightValidation(booking, flightMap);
        assertTrue(flightValidation.existingFlight());
    }

    @Test
    public void flightExistFalse() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY1110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getAirlineCode(), new ArrayList<>());
        flightMap.get(flight.getAirlineCode()).add(flight);
        flightValidation flightValidation = new flightValidation(booking, flightMap);
        assertFalse(flightValidation.existingFlight());
    }

    @Test
    public void seatAvailabilityTrue() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> map2 = new HashMap<>();
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        flightValidation flightValidation = new flightValidation(booking, map2);
        assertTrue(flightValidation.availableSeats());
    }
    @Test
    public void seatAvailabilityFalse() {
        Flight flight = new Flight("Business", "BY110", "1", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> map2 = new HashMap<>();
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        flightValidation flightValidation = new flightValidation(booking, map2);
        assertFalse(flightValidation.availableSeats());
    }

}