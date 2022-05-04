package design2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.exceptions.CsvValidationException;

import csvfile.Exceptions;
import org.junit.Before;
import org.junit.Test;

import generator.Flight;
import generator.booking;
import csvfile.Reader;
import validations.flightValidation;
import validations.paymentValidation;

public class Filter1Test {
    private String workingDir;

    @Before
    public void init() {
        this.workingDir = System.getProperty("user.dir") + "/src" + "/test/java/file";
    }
    @Test
    public void validationTrue() throws IOException, CsvValidationException {
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

        Filter1 Filter1 = new Filter1(null, Exceptions);
        assertTrue(Filter1.validate(dbGenerator));
    }

    @Test
    public void validationFalse() throws IOException, CsvValidationException {
        Map<String, List<Flight>> flightMap = new HashMap<>();
        Reader Reader = new Reader(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, this.workingDir);
        Exceptions Exceptions = new Exceptions(this.workingDir);
        Flight flight = new Flight("Business", "BY110", "5", "2000", "Seattle", "San jose");
        booking booking = new booking("Nick", "BY110", "Business", "2", "123123123");
        flightMap.put(flight.getAirlineCode(), new ArrayList<>());
        flightMap.get(flight.getAirlineCode()).add(flight);
        paymentValidation paymentValidation = new paymentValidation(booking, flightMap);
        flightValidation flightValidation = new flightValidation(booking, flightMap);

        dbGenerator dbGenerator = new dbGenerator(booking, flightMap, flightValidation, paymentValidation, Reader);

        Filter1 Filter1 = new Filter1(null, Exceptions);
        assertFalse(Filter1.validate(dbGenerator));
    }
}