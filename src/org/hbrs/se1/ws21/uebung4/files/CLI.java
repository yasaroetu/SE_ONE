package org.hbrs.se1.ws21.uebung4.files;

import java.util.*;

public class CLI {
    private boolean close = false;
    private Scanner sc = new Scanner(System.in);

    public CLI() {
        do {
            System.out.print("> ");
            try {
                call(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!this.close);
    }
    public static void main(String[] args) {
        CLI c = new CLI();
    }

    public void call (String command) throws CLIException {
        command = command.toLowerCase(Locale.ROOT);
        String[] semisplit = command.split(";");
        for (String x : semisplit) {
            String[] cmdsplit = x.split(" ");
            switch (cmdsplit[0]) {
                case "enter":
                    this.Enter();
                    break;
                case "store":
                    this.Store();
                    break;
                case "load":
                    this.Load(cmdsplit);
                    break;
                case "dump":
                    this.Dump();
                    break;
                case "search":
                    this.Search(cmdsplit);
                    break;
                case "exit":
                    this.Exit();
                    break;
                case "help":
                    this.Help();
                    break;
                default:
                    throw new CLIException("Ein nicht bekannter Befehl wurde eingegeben. Fuehr mehr Informationen gebe bitte 'help' ein.");
                }
            }
    }
    private void Enter() throws CLIException {

        String[] data = {"ID: ","Vorname: ","Nachname: ","Expertise (1: Beginner, 2: Experte, 3: Top-Performer): "};
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            data[i] = sc.nextLine();
            if(data[i].equals("")) {
                throw new CLIException("Angaben nicht korrekt!");
            }
        }
        System.out.print("Abteilung (Angabe nicht noetig): ");
        String abteilung = sc.next();

        Container c = Container.getInstance();
        try {
            c.addMember(new Mitarbeiter(Integer.parseInt(data[0]), data[1], data[2], abteilung, Integer.parseInt(data[3])));
        } catch (Exception ex) {
            throw new CLIException(ex.getMessage());
        }
    }
    private void Store() throws CLIException {
        Container c = Container.getInstance();
        try {
            c.store();
        } catch (Exception ex) {
            throw new CLIException(ex.getMessage());
        }
    }
    private void Load(String[] cmd) throws CLIException {
        Container c = Container.getInstance();
        if(cmd.length > 1) {
            try {
                switch (cmd[1]) {
                    case "merge":
                        c.load(true);
                        break;
                    case "force":
                        c.load(false);
                        break;
                    default:
                        throw new CLIException("Parameter " + cmd[1] + "nicht bekannt.");
                }
            } catch (Exception ex) {
                throw new CLIException(ex.getMessage());
            }
        } else
            throw new CLIException("Error: No Parameter found 'load [merge|force]'.");
    }
    private void Dump() throws CLIException {
        Iterator iter = Container.getInstance().getCurrentList().iterator();
        if(iter.hasNext())
            System.out.format("%s%32s%32s%32s\n","ID","Vorname","Nachname","Abteilung");
        else
            throw new CLIException("Es konnte nichts gefunden werden.");

        var arr = Container.getInstance().getCurrentList().stream().map(x -> x.getID()).reduce(-1,(x,y) -> x < 0 ? y : x < y ? x : y);
        System.out.println(arr);

        while(iter.hasNext()) {
            System.out.println(iter.next());
            /* currentMember = (Member)iter.next();
            System.out.format("%s%32s%32s%32s\n",currentMember.getID(),currentMember.Vorname(),currentMember.Nachname(),currentMember.Abteilung());*/
        }
    }
    private void Search(String[] cmd) throws CLIException {
        int exp = -1;
        if(cmd.length > 1)
            exp = Integer.parseInt(cmd[1]);
        int fExp = exp;
        Iterator iter = Container.getInstance().getCurrentList().stream().filter(x -> x.ExpertisenLevel() == fExp).iterator();
        if(iter.hasNext())
            System.out.format("%s%32s%32s%32s%32s\n","ID","Vorname","Nachname","Abteilung","Expertise");
        else
            throw new CLIException("Es konnte nichts gefunden werden.");
        while(iter.hasNext()) {
            Member currentMember = (Member)iter.next();
            System.out.format("%s%32s%32s%32s%32d\n",currentMember.getID(),currentMember.Vorname(),currentMember.Nachname(),currentMember.Abteilung(),currentMember.ExpertisenLevel());
        }
    }
    private void Exit() {
        this.close = true;
        System.out.println("Console closed.");
    }
    private void Help() {
        System.out.println("enter (Eingabe eines Mitarbeiters, nur Ablage in den RAM-Speicher)\n\n" +
                "store (Persistentes Abspeichern von Mitarbeiter-Objekte aus einem\n" +
                "Container-Objekt auf einen Datenträger).\n\n" +
                "load (Laden von Mitarbeiter-Objekten von einem Datenträger in ein\n" +
                "Container-Objekt. Dieser Befehl kann zwei Parameter aufnehmen:\n" +
                "   merge (die geladenen Mitarbeiter-Objekte werden mit den\n" +
                "   Mitarbeiter-Objekten im Speicher vereinigt)\n" +
                "   force (die geladenen Mitarbeiter-Objekte überschreiben die\n" +
                "   Mitarbeiter-Objekte im Speicher)\n\n" +
                "dump (eine nach den eingegeben IDs sortierte Ausgabe der MitarbeiterObjekte inklusive aller eingegeben Angaben (ohne Expertisen)).\n\n" +
                "search [1|2|3] (Suche nach Expertisen; \n\n" +
                "exit (Verlassen der Anwendung)\n\n" +
                "help (Anzeige aller möglichen Befehle)\n\n");
    }

}