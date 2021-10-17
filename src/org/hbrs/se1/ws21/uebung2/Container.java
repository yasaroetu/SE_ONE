package org.hbrs.se1.ws21.uebung2;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Container {
    ArrayList<Member> m = new ArrayList<Member>();

    public void addMember(Member member) throws ContainerException {
        if(this.m.stream().anyMatch(x -> x.getID() == member.getID()) || member.getID() == null)
            throw new ContainerException(member.getID());
        else
            m.add(member);
    }
    public String deleteMember(int id) {
        Member r = null;
        for(Member x : this.m) {
            if(x.getID() == id) {
                r = x;
                break;
            }
        }
        if(r != null) {
            m.remove(r);
        }
        return r == null ? "Kein Member mit der ID: " + id + " gefunden." : "Member mit der ID: " + id + " entfernt.";
    }
    public void dump() {
        for(Member x : this.m) {
            System.out.println(x.toString());
        }
    }
    public int size() {
        return this.m.size();
    }
}
