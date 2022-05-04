package design1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import generator.Flight;
import options.businessCl;
import options.economyCl;
import options.premiumEcoCl;

public class Prices {
    public Map<String, List<Flight>> flightMap;
    public Map<String, List<String[]>> priceMap;

    public Prices(Map<String, List<Flight>> flightMap) {
        this.flightMap = flightMap;
        this.priceMap = new HashMap<>();
    }

    public void setPriceMap() {
        priceMap.put("Economy", new economyCl(flightMap).getprice());
        priceMap.put("PremiumEconomy", new premiumEcoCl(flightMap).getprice());
        priceMap.put("Business", new businessCl(flightMap).getprice());
    }

    public Map<String, List<String[]>> getPriceMap() {
        return priceMap;
    }

    public int getPrice(String category, String flightNumber) {
        for(String key : priceMap.keySet()) {
            if (category.equals(key)) {
                List<String[]> curPrice = priceMap.get(key);
                for(String[] prices : curPrice) {
                    if(prices[0].equals(flightNumber)) {
                        return Integer.parseInt(prices[1]);
                    }
                }
            }
        }
        return 0;
    }

}
