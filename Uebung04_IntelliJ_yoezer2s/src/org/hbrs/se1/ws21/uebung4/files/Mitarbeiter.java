package org.hbrs.se1.ws21.uebung4.files;

public class Mitarbeiter implements Member {

    private int id = -1;
    private String vorname = "";
    private String nachname = "";
    private String abteilung = "";
    private int expertisenLevel = 1;

    Mitarbeiter(int id,String vorname,String nachname,String abteilung,int expertisenLevel) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.abteilung = abteilung;
        this.expertisenLevel = expertisenLevel;
    }

    @Override
    public Integer getID() { return id; }
    @Override
    public String Vorname() { return this.vorname; }
    @Override
    public String Nachname() { return this.nachname; }
    @Override
    public String Abteilung() { return this.abteilung; }
    @Override
    public int ExpertisenLevel() { return this.expertisenLevel; }
}
