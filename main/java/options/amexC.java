package options;

import validations.cardValidation;

public class amexC implements cardValidation {
    private String cardNum;

    public amexC(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public boolean validateCard() {
        return cardNum.length() == 15 && cardNum.charAt(0) == '3' && (cardNum.charAt(1) == '4' || cardNum.charAt(1) == '7');
    }
}