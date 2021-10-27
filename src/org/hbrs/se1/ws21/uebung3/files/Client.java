package org.hbrs.se1.ws21.uebung3.files;

public class Client {
    public static void main(String[] args) {
        Container container = Container.getInstance();
        try {
            container.addMember(new MemberKonkret(1));
            container.addMember(new MemberKonkret(2));

            MemberView.dump(container.getCurrentList());

            container.store();

            container.deleteMember(1);
            container.deleteMember(2);

            MemberView.dump(container.getCurrentList());

            container.load();

            MemberView.dump(container.getCurrentList());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
