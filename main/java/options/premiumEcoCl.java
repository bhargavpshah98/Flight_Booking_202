package options;

import generator.Flight;
import categoryinitializer.CatInit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class premiumEcoCl implements CatInit {
    private Map<String, List<Flight>> flightMap;
    private List<String[]> result;
    private final List<String[]> seatList;

    public premiumEcoCl(Map<String, List<Flight>> flightMap) {
        this.flightMap = flightMap;
        this.seatList = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    @Override
    public List<String[]> getprice() {
        for(Map.Entry<String, List<Flight>> entry : flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCat().equals("Premium Economy")){
                    String[] curPrice = {flight.getAirlineCode(), String.valueOf(flight.getPrice())};
                    result.add(curPrice);
                }
            }
        }
        return result;
    }

    @Override
    public List<String[]> getseats() {
        for(Map.Entry<String, List<Flight>> entry : flightMap.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCat().equals("PremiumEconomy")){
                    String[] curseats = {flight.getAirlineCode(), String.valueOf(flight.getSeatAvailability())};
                    seatList.add(curseats);
                }
            }
        }
        return seatList;
    }
}
