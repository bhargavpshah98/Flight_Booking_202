package options;

import generator.Flight;
import categoryinitializer.CatInit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class economyCl implements CatInit {
    private final Map<String, List<Flight>> flightMap;

    private final List<String[]> priceList;
    private final List<String[]> seatList;

    public economyCl(Map<String, List<Flight>> flightMap) {
        this.flightMap = flightMap;
        this.seatList = new ArrayList<>();
        this.priceList = new ArrayList<>();
    }

    @Override
    public List<String[]> getprice() {
        for(Map.Entry<String, List<Flight>> entry : this.flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCat().equals("Economy")){
                    String[] curPrice = {flight.getAirlineCode(), String.valueOf(flight.getPrice())};
                    this.priceList.add(curPrice);
                }
            }
        }
        return this.priceList;
    }

    @Override
    public List<String[]> getseats() {
        for(Map.Entry<String, List<Flight>> entry : this.flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCat().equals("Economy")){
                    String[] curseats = {flight.getAirlineCode(), String.valueOf(flight.getSeatAvailability())};
                    this.seatList.add(curseats);
                }
            }
        }
        return this.seatList;
    }
}
