package design1;

import generator.Flight;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SeatsTest {

    @Test
    public void changeOfSeat() {
        Map<String, List<Flight>> map1 = new HashMap<>();

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        map1.put(flight.getAirlineCode(), new ArrayList<>());
        map1.get(flight.getAirlineCode()).add(flight);
        Seats Seats = new Seats(map1);
        Seats.setSeatMap();
        assertTrue(Seats.modifySeat("Business", "3","BY110"));
        assertEquals(2, flight.getSeatAvailability());
    }
}