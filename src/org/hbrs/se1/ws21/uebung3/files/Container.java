package org.hbrs.se1.ws21.uebung3.files;

import org.hbrs.se1.ws21.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws21.uebung3.persistence.PersistenceStrategyStream;

import java.util.ArrayList;
import java.util.List;

public final class Container {
    private List<Member> members = new ArrayList<Member>();

    public static volatile Container cInstance = null;
    //Singelton Pattern
    public Container() {
        // DIREKT NACH DER INSTANZIIERUNG DEN ERSTEN CONTAINER ALS FINALE INSTANZ NUTZEN
        if(this.cInstance == null) {
            cInstance = this;
        }
    }
    // GETINSTANCE NUTZEN WENN AUF WUNDERSAME ART UND WEISE CINSTANCE WIEDER NULL IST
    public static Container getInstance() {
        if(cInstance == null) {
            cInstance = new Container();
        }
        return cInstance;
    }

    public void addMember(Member member) throws ContainerException {
        if(this.cInstance.members.stream().anyMatch(x -> x.getID() == member.getID()) || member.getID() == null)
            throw new ContainerException(member.getID());
        else
            this.cInstance.members.add(member);
    }
    public String deleteMember(int id) {
        Member r = null;
        for(Member x : this.cInstance.members) {
            if(x.getID() == id) {
                r = x;
                this.cInstance.members.remove(x);
                break;
            }
        }
        return r == null ? "Kein Member mit der ID: " + id + " gefunden." : "Member mit der ID: " + id + " entfernt.";
    }

    public int size() {
        return this.cInstance.members.size();
    }

    public List<Member> getCurrentList() { return this.cInstance.members; };

    public void store() throws PersistenceException {
        try {
            new PersistenceStrategyStream<Member>().save(this.cInstance.members);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void load() throws PersistenceException {
        try {
            this.cInstance.members = new PersistenceStrategyStream<Member>().load();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
