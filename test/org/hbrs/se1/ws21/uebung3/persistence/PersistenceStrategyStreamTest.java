package org.hbrs.se1.ws21.uebung3.persistence;

import org.hbrs.se1.ws21.uebung3.files.Container;
import org.hbrs.se1.ws21.uebung3.files.Member;
import org.hbrs.se1.ws21.uebung3.files.MemberKonkret;
import org.hbrs.se1.ws21.uebung3.files.MemberView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceStrategyStreamTest {

    private Container cContainer;
    private Container dContainer;

    @BeforeEach
    void setup() {
        cContainer = new Container();
        dContainer = new Container();
    }
    @Test
    void setLocation() {
        PersistenceStrategyStream pss = new PersistenceStrategyStream();
        pss.setLocation("\\asdasd\\DiesDas");

        if(cContainer.size() == 0) {
            assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
            assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));
        }
        assertThrows(PersistenceException.class,() -> pss.save(cContainer.getCurrentList()));

        //pos_ÄK1
        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }

    @Test
    void save() {
        assertThrows(PersistenceException.class,() -> new PersistenceStrategyStream().save(null));

        if(cContainer.size() == 0) {
            assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
            assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));
        }

        assertDoesNotThrow(() -> new PersistenceStrategyStream().save(cContainer.getCurrentList()));

        //pos_ÄK1
        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }

    @Test
    void load() {
        if(cContainer.size() == 0) {
            assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
            assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));
        }
        assertDoesNotThrow(() -> new PersistenceStrategyStream().save(cContainer.getCurrentList()));

        assertDoesNotThrow(() -> new PersistenceStrategyStream().load());
        List<Member> l = null;
        try {
            l = new PersistenceStrategyStream().load();
        } catch (Exception ex) {}

        assertTrue(l.stream().anyMatch(x -> cContainer.getCurrentList().stream().anyMatch(y -> y.getID().equals(x.getID()))));

        //pos_ÄK1
        assertEquals(dContainer.deleteMember(1),"Member mit der ID: 1 entfernt.");
        assertEquals(cContainer.deleteMember(2),"Member mit der ID: 2 entfernt.");
    }
}