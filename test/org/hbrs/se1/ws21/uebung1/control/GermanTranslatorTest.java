package org.hbrs.se1.ws21.uebung1.control;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    GermanTranslator g;
    @BeforeEach
    void setup() {
        g = new GermanTranslator();
    }
    @Test
    void translateNumber() {
        assertEquals(g.translateNumber(1),"eins");
        assertEquals(g.translateNumber(2),"zwei");
        assertEquals(g.translateNumber(3),"drei");
        assertEquals(g.translateNumber(4),"vier");
        assertEquals(g.translateNumber(5),"fuenf");
        assertEquals(g.translateNumber(6),"sechs");
        assertEquals(g.translateNumber(7),"sieben");
        assertEquals(g.translateNumber(8),"acht");
        assertEquals(g.translateNumber(9),"neun");
        assertEquals(g.translateNumber(10),"zehn");
    }
}