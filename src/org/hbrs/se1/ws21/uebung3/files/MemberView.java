package org.hbrs.se1.ws21.uebung3.files;

import java.util.List;

public final class MemberView {
    public static void dump (List<Member> members) {
        String output = "";
        for(Member x : members) {
            if(x.equals(members.get(0)))
                output += x.toString();
            else
                output +=  "\n" + x.toString();
        }
        output = output == "" ? "Member list is empty." : output;
        System.out.println(output);
    }
}
