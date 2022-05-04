package design2;

import generator.Flight;
import generator.booking;
import csvfile.Reader;
import csvfile.Exceptions;
import org.junit.Before;
import org.junit.Test;
import validations.flightValidation;
import validations.paymentValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Filter5Test {
    private String workingDir;

    @Before
    public void init() {
        this.workingDir = System.getProperty("user.dir") + "/src" + "/test/java/file";
    }
    @Test
    public void validationTrue() {
        Map<String, List<Flight>> map2 = new HashMap<>();
        Reader Reader = new Reader(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, this.workingDir);
        Exceptions Exceptions = new Exceptions(this.workingDir);

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, map2);
        flightValidation flightValidation = new flightValidation(booking, map2);

        dbGenerator dbGenerator = new dbGenerator(booking, map2, flightValidation, paymentValidation, Reader);
        Filter5 Filter5 = new Filter5(null, Exceptions);
        assertTrue(Filter5.validate(dbGenerator));
    }

    @Test
    public void validationFalse() {
        Map<String, List<Flight>> map2 = new HashMap<>();
        Reader Reader = new Reader(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, this.workingDir);
        Exceptions Exceptions = new Exceptions(this.workingDir);

        Flight flight = new Flight("Business", "BY110", "1", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, map2);
        flightValidation flightValidation = new flightValidation(booking, map2);

        dbGenerator dbGenerator = new dbGenerator(booking, map2, flightValidation, paymentValidation, Reader);
        Filter5 Filter5 = new Filter5(null, Exceptions);
        assertFalse(Filter5.validate(dbGenerator));
    }

}