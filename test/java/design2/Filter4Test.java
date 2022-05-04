package design2;

import generator.Flight;
import generator.booking;
import csvfile.Reader;
import org.junit.Before;
import org.junit.Test;
import validations.flightValidation;
import validations.paymentValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Filter4Test {
    private String workingDir;

    @Before
    public void init() {
        this.workingDir = System.getProperty("user.dir") + "/src" + "/test/java/file";
    }
    @Test
    public void validate() {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        Reader Reader = new Reader(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, this.workingDir);

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        flightMap.put(flight.getAirlineCode(), new ArrayList<>());
        flightMap.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, flightMap);
        flightValidation flightValidation = new flightValidation(booking, flightMap);

        dbGenerator dbGenerator = new dbGenerator(booking, flightMap, flightValidation, paymentValidation, Reader);
        Filter4 Filter4 = new Filter4(null);
        assertTrue(Filter4.validate(dbGenerator));

    }
}