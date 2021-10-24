package org.hbrs.se1.ws21.uebung3.persistence;

import org.hbrs.se1.ws21.uebung3.files.Container;
import org.hbrs.se1.ws21.uebung3.files.MemberKonkret;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceStrategyMongoDBTest {

    private Container cContainer;
    private Container dContainer;

    @BeforeEach
    void setup() {
        cContainer = new Container();
        dContainer = new Container();
    }
    @Test
    void openConnection() {
        assertThrows(UnsupportedOperationException.class,() -> new PersistenceStrategyMongoDB().openConnection());
    }
    @Test
    void closeConnection() {
        assertThrows(UnsupportedOperationException.class,() -> new PersistenceStrategyMongoDB().openConnection());
    }
    @Test
    void save() {
        assertDoesNotThrow(() -> cContainer.addMember(new MemberKonkret(1)));
        assertDoesNotThrow(() -> dContainer.addMember(new MemberKonkret(2)));
        assertThrows(UnsupportedOperationException.class,() -> new PersistenceStrategyMongoDB().save(cContainer.getCurrentList()));
    }

    @Test
    void load() {
        assertThrows(UnsupportedOperationException.class,() -> new PersistenceStrategyMongoDB().load());
    }
}