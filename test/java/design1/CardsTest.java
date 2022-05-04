package design1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardsTest {

    @Test
    public void cardTrue() {
        Cards Cards = new Cards("5410000000000000");
        assertTrue(Cards.cardValid());
    }

    @Test
    public void cardFalse() {
        Cards Cards = new Cards("123123123");
        assertFalse(Cards.cardValid());
    }
}