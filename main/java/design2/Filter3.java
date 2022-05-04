package design2;

import java.io.IOException;

public class Filter3 extends class1 {
    public Filter3(class1 nextBookingFilter) {
        super(nextBookingFilter);
    }

    @Override
    public boolean validate(dbGenerator dbGenerator) throws IOException {
        dbGenerator.generateCSV();
        return true;
    }
}
