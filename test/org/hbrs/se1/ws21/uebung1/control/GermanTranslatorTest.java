package org.hbrs.se1.ws21.uebung1.control;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    private GermanTranslator g;
    @BeforeEach
    void setup() {
        g = new GermanTranslator();
    }
    @Test
    void translateNumber() {

        //pos_ÄK
        assertEquals(g.translateNumber(1),"eins");
        assertEquals(g.translateNumber(5),"fuenf");
        assertEquals(g.translateNumber(10),"zehn");

        //neg_ÄK
        assertEquals(g.translateNumber(-5),"Uebersetzung der Zahl " + -5 + " nicht moeglich " + g.version());
        assertEquals(g.translateNumber(55),"Uebersetzung der Zahl " + 55 + " nicht moeglich " + g.version());
        assertNotEquals(g.translateNumber(-5),"minusfuenf");
        assertNotEquals(g.translateNumber(55),"fuenfundfuenfzig");


    }
}