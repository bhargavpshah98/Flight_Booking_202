package design2;

import generator.Flight;
import generator.booking;
import csvfile.Reader;
import org.junit.Before;
import org.junit.Test;
import validations.flightValidation;
import validations.paymentValidation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Filter3Test {
    private String workingDir;

    @Before
    public void init() {
        this.workingDir = System.getProperty("user.dir") + "/src" + "/test/java/file";
    }
    @Test
    public void validate() throws IOException {
        Map<String, List<Flight>> map2 = new HashMap<>();
        Reader Reader = new Reader(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, this.workingDir);

        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "5410000000000000");
        map2.put(flight.getAirlineCode(), new ArrayList<>());
        map2.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, map2);
        flightValidation flightValidation = new flightValidation(booking, map2);

        dbGenerator dbGenerator = new dbGenerator(booking, map2, flightValidation, paymentValidation, Reader);
        Filter3 Filter3 = new Filter3(null);
        assertTrue(Filter3.validate(dbGenerator));
    }
}