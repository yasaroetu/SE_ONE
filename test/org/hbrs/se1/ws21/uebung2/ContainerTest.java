package org.hbrs.se1.ws21.uebung2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container c;
    @BeforeEach
    void setup(){
        c = new Container();
    }

    @Test
    void addMember() {

        // pos_ÄK1
        assertDoesNotThrow(() -> c.addMember(new Mitarbeiter(1)));
        assertDoesNotThrow(() -> c.addMember(new Mitarbeiter(2)));

        // neg_ÄK1
        assertThrows(ContainerException.class,() -> c.addMember(new Mitarbeiter(1)));
        assertThrows(ContainerException.class,() -> c.addMember(new Mitarbeiter(2)));

        //neg_ÄK2
        assertThrows(ContainerException.class,() -> c.addMember(new Mitarbeiter(null)));
    }

    @Test
    void deleteMember() {

        //pos_ÄK1
        assertEquals(c.deleteMember(1),"Kein Member mit der ID: 1 gefunden.");
        assertEquals(c.deleteMember(2),"Kein Member mit der ID: 2 gefunden.");

    }
}