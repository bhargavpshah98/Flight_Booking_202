package design1;

import generator.Flight;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PricesTest {

    @Test
    public void totalPrice() {
        Map<String, List<Flight>> map2 = new HashMap<>();

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        Prices Prices = new Prices(map2);
        Prices.setPriceMap();
        assertEquals(2000, Prices.getPrice("Business", "BY110"));
    }
}