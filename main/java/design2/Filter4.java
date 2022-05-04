package design2;

public class Filter4 extends class1 {
    public Filter4(class1 nextBookingFilter) {
        super(nextBookingFilter);
    }

    @Override
    public boolean validate(dbGenerator dbGenerator) {
        dbGenerator.modifySeat();
        return true;
    }
}
