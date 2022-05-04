package generator;

import java.util.ArrayList;
import java.util.List;

public class flightGenerator {
    private List<String[]> flightdb;
    private List<Flight> flights;

    public flightGenerator(List<String[]> flightdb) {
        this.flightdb = flightdb;
        this.flights = new ArrayList<>();
    }

    public void generateList() {
        for(String[] flight : flightdb) {
            String cat = flight[0];
            String airlineCode = flight[1];
            String seat = flight[2];
            String price = flight[3];
            String arrivalCity = flight[4];
            String departureCity = flight[5];
            Flight flight1 = new Flight(cat, airlineCode, seat, price, arrivalCity, departureCity);
            flights.add(flight1);
        }
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
