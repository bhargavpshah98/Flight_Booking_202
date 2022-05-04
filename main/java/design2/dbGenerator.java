package design2;

import generator.Flight;
import generator.booking;
import csvfile.Reader;
import validations.flightValidation;
import validations.paymentValidation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class dbGenerator {
    private booking booking;
    private Map<String , List<Flight>> flightMap;
    private flightValidation flightValidation;
    private paymentValidation paymentValidation;
    private Reader Reader;

    public dbGenerator(booking booking, Map<String, List<Flight>> flightMap, flightValidation flightValidation, paymentValidation paymentValidation, Reader Reader) {
        this.booking = booking;
        this.flightMap = flightMap;
        this.flightValidation = flightValidation;
        this.paymentValidation = paymentValidation;
        this.Reader = Reader;
    }

    public boolean ExistingFlight() {
        return flightValidation.existingFlight();
    }

    public boolean isSeatEnough() {
        return flightValidation.availableSeats();
    }

    public boolean isCardValid() {
        return paymentValidation.validationOfCard();
    }

    public String getBookName() {
        return booking.getBookerName();
    }

    public void modifySeat(){
        flightValidation flightValidation = new flightValidation(booking, flightMap);
        flightValidation.changeOfSeat();
    }

    public void generateCSV() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(booking.getBookerName()).append(",");
        sb.append(booking.getAirCode()).append(",");
        sb.append(booking.getsCat()).append(",");
        sb.append(booking.getSeatAvailability()).append(",");
        sb.append(paymentValidation.totalPrice());
        Reader.insertData(sb.toString());
    }

}
