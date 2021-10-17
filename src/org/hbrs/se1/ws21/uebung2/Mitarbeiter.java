package org.hbrs.se1.ws21.uebung2;

public class Mitarbeiter implements Member {

    private Integer id;
    Mitarbeiter(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Member (ID = " + this.getID() + ")";
    }

    public Integer getID() {
        return this.id;
    }
}
