package org.hbrs.se1.ws21.uebung3.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container cContainer;
    private Container dContainer;
    @BeforeEach
    void setup(){
        cContainer = Container.getInstance();
        dContainer = Container.getInstance();
    }

    @Test
    void addAndDeleteMember() {
        // pos_ÄK1
        assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
        assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));

        // neg_ÄK1
        assertThrows(ContainerException.class,() -> dContainer.addMember(new MemberKonkret(1)));
        assertThrows(ContainerException.class,() -> cContainer.addMember(new MemberKonkret(2)));

        //neg_ÄK2
        assertThrows(ContainerException.class,() -> dContainer.addMember(new MemberKonkret(null)));

        //pos_ÄK1
        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");

        //neg_ÄK1
        assertNotEquals(cContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertNotEquals(dContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }

    @Test
    void store() {
        // pos_ÄK1
        assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
        assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));

        assertDoesNotThrow(() -> cContainer.store());

        //pos_ÄK1
        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }
    @Test
    void load() {
        // pos_ÄK1
        assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
        assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));

        assertDoesNotThrow(() -> cContainer.store());

        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");

        assertDoesNotThrow(() -> cContainer.load());

        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }
}