package design2;

import csvfile.Exceptions;

public class Filter1 extends class1 {
    private Exceptions Exceptions;
    public Filter1(class1 nextBookingFilter, Exceptions Exceptions) {
        super(nextBookingFilter);
        this.Exceptions = Exceptions;
    }

    @Override
    public boolean validate(dbGenerator dbGenerator) {
        if (dbGenerator.isCardValid()) {
            System.out.println("Card Validated");
            return true;
        }
        String bookname = dbGenerator.getBookName();
        String content = "Please enter correct booking details for " + bookname + " : invalid card";
        Exceptions.createFile();
        Exceptions.writeFile(content);
        return false;
    }
}
