package org.hbrs.se1.ws21.uebung8;

public class Hotelsuche {
    public static void main(String[] args) {
        System.out.println(new Hotelsuche().suche(new Suchauftrag("Schweiz")).getBeschreibung());
    }

    public Suchergebnis suche(Suchauftrag s) {
        return new ReiseAnbieterAdapter().suche(s);
    }
}
