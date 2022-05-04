package design1;

import generator.Flight;
import options.businessCl;
import options.economyCl;
import options.premiumEcoCl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Seats {
    public Map<String, List<Flight>> map2;
    public Map<String, List<String[]>> map3;
    public Seats(Map<String, List<Flight>> map2) {
        this.map2 = map2;
        this.map3 = new HashMap<>();
    }

    public void setSeatMap() {
        map3.put("Economy", new economyCl(map2).getseats());
        map3.put("PremiumEconomy", new premiumEcoCl(map2).getseats());
        map3.put("Business", new businessCl(map2).getseats());
    }

    public Map<String, List<String[]>> getMap3() {
        return map3;
    }

    public boolean modifySeat(String category, String takenseat, String flightNum) {
        for(String key : map3.keySet()) {
            if(key.equals(category)) {
                List<String[]> seatList = map3.get(key);
                for(String[] seat : seatList) {
                    if(flightNum.equals(seat[0])) {
                        int curSeat = Integer.parseInt(seat[1]) - Integer.parseInt(takenseat);
                        seat[1] = String.valueOf(curSeat);
                        List<Flight> flights = map2.get(flightNum);
                        for(Flight flight: flights) {
                            if (flight.getCat().equals(category) && flight.getAirlineCode().equals(flightNum)) {
                                flight.setSeatAvailability(curSeat);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
