package org.hbrs.se1.ws21.uebung2;

import java.io.Serializable;

public class MemberKonkret implements Member {

    private Integer id;
    MemberKonkret(Integer id) {
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
