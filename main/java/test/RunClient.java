package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.exceptions.CsvValidationException;
import csvfile.Exceptions;
import csvfile.Reader;
import design2.*;
import generator.Flight;
import generator.booking;
import generator.bookingInit;
import generator.flightGenerator;
import validations.flightValidation;
import validations.paymentValidation;


public class RunClient {
    public static void main(String[] args) throws IOException, CsvValidationException {
        Reader Reader = new Reader(new String[]{"Booking name", " flight number", "Category", " number of seats booked", " total price"}, args[2]);
        Exceptions Exceptions = new Exceptions(args[3]);

        Map<String, List<Flight>> flightMap = new HashMap<>();
        // read flight data
        List<String[]> flightsdata = Reader.readData(args[1]);
        flightGenerator flightGenerator = new flightGenerator(flightsdata);
        flightGenerator.generateList();

        // build flight map
        for(Flight flight1 : flightGenerator.getFlights()) {
            String key = flight1.getAirlineCode();
            if (!flightMap.containsKey(key)) {
                flightMap.put(key, new ArrayList<>());
            }
            flightMap.get(key).add(flight1);
        }
        
        // read order data
        List<String[]> orders = Reader.readData(args[0]);

        bookingInit bookingInit = new bookingInit(orders);
        List<booking> bookingList = bookingInit.generateList();

        // Iterate order list
        for (booking booking : bookingList) {
            System.out.println("*** Order Information --->");
            System.out.println(booking.getOrder());

            paymentValidation paymentValidation = new paymentValidation(booking, flightMap);
            flightValidation flightValidation = new flightValidation(booking, flightMap);

            dbGenerator dbGenerator = new dbGenerator(booking, flightMap, flightValidation, paymentValidation, Reader);

            class1 generateresFilter = new Filter3(null);
            class1 modifyseatFilter = new Filter4(generateresFilter);
            class1 cardCheck = new Filter1(modifyseatFilter, Exceptions);
            class1 seatCheck = new Filter5(cardCheck, Exceptions);
            class1 flightCheck = new Filter2(seatCheck, Exceptions);
            flightCheck.doFilter(dbGenerator);

            System.out.println("--------------------------------------------");
        }

    }
}
