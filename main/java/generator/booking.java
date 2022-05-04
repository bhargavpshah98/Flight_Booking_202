package generator;

public class booking {
    private String bookerName;
    private String airCode;
    private String sCat;
    private String seatAvailability;
    private String card;


    public booking(String bookerName, String airCode, String sCat, String seatAvailability, String card) {
        this.bookerName = bookerName;
        this.airCode = airCode;
        this.sCat = sCat;
        this.seatAvailability = seatAvailability;
        this.card = card;
    }

    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public String getAirCode() {
        return airCode;
    }

    public void setAirCode(String airCode) {
        this.airCode = airCode;
    }

    public String getsCat() {
        return sCat;
    }

    public void setsCat(String sCat) {
        this.sCat = sCat;
    }

    public String getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(String seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }
    public String getOrder() {
        return "bookingName: " + this.bookerName +
                ", flightNumber: " + this.airCode +
                ", category: " + this.sCat +
                ", # of seats: " + this.seatAvailability +
                ", card: " + this.card;
    }
}
