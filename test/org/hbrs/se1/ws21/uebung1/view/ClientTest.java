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
    void display() {
        c.display(11);
    }
}