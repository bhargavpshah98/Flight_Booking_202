package design2;

import csvfile.Exceptions;

public class Filter2 extends class1 {
    private Exceptions Exceptions;

    public Filter2(class1 nextBookingFilter, Exceptions Exceptions) {
        super(nextBookingFilter);
        this.Exceptions = Exceptions;
    }

    @Override
    public boolean validate(dbGenerator dbGenerator) {
        if (dbGenerator.ExistingFlight()){
            System.out.println("Flight Available");
            return true;
        }
        // Flight is not available
        String bookname = dbGenerator.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : No such flight number";
        Exceptions.createFile();
        Exceptions.writeFile(content);
        return false;
    }
}
