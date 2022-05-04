package design1;

import options.amexC;
import options.discoverC;
import options.masterC;
import options.visaC;

public class Cards {
    private String cardNumber;
    private amexC amexC;
    private masterC masterC;
    private discoverC discoverC;
    private visaC visaC;
    public Cards(String cardNumber) {
        this.cardNumber = cardNumber;
        this.amexC = new amexC(cardNumber);
        this.masterC = new masterC(cardNumber);
        this.discoverC = new discoverC(cardNumber);
        this.visaC = new visaC(cardNumber);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public amexC getAmexCard() {
        return amexC;
    }

    public masterC getMasterCard() {
        return masterC;
    }

    public discoverC getDiscoverCard() {
        return discoverC;
    }

    public visaC getVisaCard() {
        return visaC;
    }

    public boolean cardValid() {
        return amexC.validateCard() || masterC.validateCard() || discoverC.validateCard() || visaC.validateCard();
    }
}
