package design2;

import csvfile.Exceptions;

public class Filter5 extends class1 {
    private Exceptions Exceptions;
    public Filter5(class1 nextBookingFilter, Exceptions Exceptions) {
        super(nextBookingFilter);
        this.Exceptions = Exceptions;
    }

    @Override
    public boolean validate(dbGenerator dbGenerator) {
        if (dbGenerator.isSeatEnough()) {
            System.out.println("Seat Available");
            return true;
        }
        String bookname = dbGenerator.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : seat is not enough";
        Exceptions.createFile();
        Exceptions.writeFile(content);
        return false;
    }
}
