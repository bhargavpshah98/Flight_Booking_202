package options;

import generator.Flight;
import categoryinitializer.CatInit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class businessCl implements CatInit {
    private Map<String, List<Flight>> map;
    private List<String[]> result;
    private final List<String[]> list;
    public businessCl(Map<String, List<Flight>> map) {
        this.map = map;
        this.list = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    @Override
    public List<String[]> getprice() {
        for(Map.Entry<String, List<Flight>> entry : map.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCat().equals("Business")){
                    String[] curPrice = {flight.getAirlineCode(), String.valueOf(flight.getPrice())};
                    result.add(curPrice);
                }
            }
        }
        return result;
    }

    @Override
    public List<String[]> getseats() {
        for(Map.Entry<String, List<Flight>> entry : map.entrySet()) {
            List<Flight> flights = entry.getValue();
            for(Flight flight : flights) {
                if (flight.getCat().equals("Business")){
                    String[] curseats = {flight.getAirlineCode(), String.valueOf(flight.getSeatAvailability())};
                    list.add(curseats);
                }
            }
        }
        return list;
    }
}
