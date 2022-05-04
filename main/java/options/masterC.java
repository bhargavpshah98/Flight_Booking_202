package options;

import validations.cardValidation;

public class masterC implements cardValidation {
    private String cardNum;

    public masterC(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public boolean validateCard() {
        if (cardNum.length() == 16 && cardNum.charAt(0) == '5') { // 1st letter
            for(int i = 1; i <= 5; i++) { // 2nd letter
                if (cardNum.charAt(1) == (char)(i + '0')) {
                    return true;
                }
            }
        }
        return false;
    }
}