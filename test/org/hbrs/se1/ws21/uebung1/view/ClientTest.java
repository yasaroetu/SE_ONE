package org.hbrs.se1.ws21.uebung1.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client c;
    @BeforeEach
    void setup() {
        c = new Client();
    }
    @Test
    void displayTest() {
        c.display(1);
        c.display(5);
        c.display(10);
        c.display(-5);
        c.display(55);
    }
}