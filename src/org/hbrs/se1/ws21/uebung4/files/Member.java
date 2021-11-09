package org.hbrs.se1.ws21.uebung4.files;

import java.io.Serializable;

public interface Member extends Serializable {

    // ID ist über einen Konstruktor einer abgeleiteten Klasse
    // explizit außerhalb der Container-Klasse zu belegen
    // --> Primärschlüssel zur Unterscheidung aller Member-Objekte

    Integer getID();
    String Vorname();
    String Nachname();
    String Abteilung();
    int ExpertisenLevel();

    public String toString();

}
