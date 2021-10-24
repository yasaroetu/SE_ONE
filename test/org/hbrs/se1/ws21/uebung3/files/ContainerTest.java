package org.hbrs.se1.ws21.uebung3.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container cContainer;
    private Container dContainer;
    @BeforeEach
    void setup(){
        cContainer = new Container();
        dContainer = new Container();
    }

    @Test
    void addAndDeleteMember() {
        if(cContainer.size() == 0) {
            // pos_ÄK1
            assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
            assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));
        }

        // neg_ÄK1
        assertThrows(ContainerException.class,() -> dContainer.addMember(new MemberKonkret(1)));
        assertThrows(ContainerException.class,() -> cContainer.addMember(new MemberKonkret(2)));

        //neg_ÄK2
        assertThrows(ContainerException.class,() -> dContainer.addMember(new MemberKonkret(null)));

        //pos_ÄK1
        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");

        //neg_ÄK1
        assertNotEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertNotEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }

    @Test
    void store() {
        if(cContainer.size() == 0) {
            // pos_ÄK1
            assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
            assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));
        }

        assertDoesNotThrow(() -> cContainer.store());

        //pos_ÄK1
        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }
    @Test
    void load() {
        if(cContainer.size() == 0) {
            // pos_ÄK1
            assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
            assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));
        }

        assertDoesNotThrow(() -> cContainer.store());

        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");

        assertDoesNotThrow(() -> cContainer.load());

        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }
}