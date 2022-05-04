package options;

import validations.cardValidation;

public class discoverC implements cardValidation {
    private final String cardNum;

    public discoverC(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public boolean validateCard() {
        return cardNum.length() == 16 && cardNum.startsWith("6011");
    }
}
