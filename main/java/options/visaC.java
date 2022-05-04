package options;

import validations.cardValidation;

public class visaC implements cardValidation {
    private String cardNum;

    public visaC(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public boolean validateCard() {
        return ((cardNum.length() == 13 || cardNum.length() == 16) && cardNum.charAt(0) == '4');
    }
}
