package generator;

public class Flight {
    private String cat;
    private String airlineCode;
    private String seatAvailability;
    private String price;
    private String arrivalCity;
    private String departureCity;

    public Flight(String cat, String airlineCode, String seatAvailability, String price, String arrivalCity, String departureCity) {
        this.cat = cat;
        this.airlineCode = airlineCode;
        this.seatAvailability = seatAvailability;
        this.price = price;
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public int getSeatAvailability() {
        return Integer.parseInt(seatAvailability);
    }

    public void setSeatAvailability(int seatAvailability) {
        this.seatAvailability = String.valueOf(seatAvailability);
    }

    public int getPrice() {
        return Integer.parseInt(price);
    }

    public void setPrice(int price) {
        this.price = String.valueOf(price);
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }
}
