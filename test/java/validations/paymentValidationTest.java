package validations;

import generator.Flight;
import generator.booking;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class paymentValidationTest {

    @Test
    public void isTrue() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        Map<String, List<Flight>> flightMap = new HashMap<>();
        flightMap.put(flight.getAirlineCode(), new ArrayList<>());
        flightMap.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, flightMap);
        assertTrue(paymentValidation.validationOfCard());
    }

    @Test
    public void isFalse() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "123123123");
        Map<String, List<Flight>> map2 = new HashMap<>();
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, map2);
        assertFalse(paymentValidation.validationOfCard());
    }
    @Test
    public void totalPrice() {
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "1", "123123123");
        Map<String, List<Flight>> map2 = new HashMap<>();
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, map2);
        Assert.assertEquals(2000, paymentValidation.totalPrice());
    }

}