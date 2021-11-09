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
                case "":
                    break;
                default:
                    throw new CLIException("Ein nicht bekannter Befehl wurde eingegeben. Fuehr mehr Informationen gebe bitte 'help' ein.");
                }
            }
    }

    /**
     *  USERSTORY 1
     *  Enter Methode
     */
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
        String abteilung = sc.nextLine();

        Container c = Container.getInstance();
        try {
            Integer exp = Integer.parseInt(data[3]);
            if(exp > 3 | exp < 1)
                throw new CLIException("Value range is to great! Excepted: [1|2|3] Current: " + exp);
            c.addMember(new Mitarbeiter(Integer.parseInt(data[0]), data[1], data[2], abteilung, exp));
        } catch (Exception ex) {
            throw new CLIException(ex.getMessage());
        }
    }

    /**
     *  USERSTORY 3
     *  Store und Load Methode
     */
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

    /**
     *  USERSTORY 2
     *  Dump Methode
     */
    private void Dump() throws CLIException {
        if(Container.getInstance().getCurrentList().size() > 0)
            System.out.println(String.format("%s%32s%32s%32s","ID","Vorname","Nachname","Abteilung"));
        else
            throw new CLIException("Es konnte nichts gefunden werden.");

        Container.getInstance().getCurrentList().stream()
                .filter(x -> x.getID() >= 0)
                .sorted((x,y) -> Integer.compare(x.getID(),y.getID()))
                .forEach(x -> System.out.println(String.format("%s%32s%32s%32s",x.getID(),x.Vorname(),x.Nachname(),x.Abteilung())));
    }

    /**
     *  USERSTORY 4
     *  Search Methode
     */
    private void Search(String[] cmd) throws CLIException {
        try {
            int exp = Integer.parseInt(cmd[1]);
            if(Container.getInstance().getCurrentList().size() > 0)
                System.out.format("%s%32s%32s%32s%32s\n","ID","Vorname","Nachname","Abteilung","Expertise");
            else
                throw new CLIException("Es konnte nichts gefunden werden.");

            Container.getInstance().getCurrentList().stream()
                    .filter(x -> x.ExpertisenLevel() == exp)
                    .sorted((x,y) -> Integer.compare(x.getID(),y.getID()))
                    .forEach(x -> System.out.println(String.format("%s%32s%32s%32s%32d\n",x.getID(),x.Vorname(),x.Nachname(),x.Abteilung(),x.ExpertisenLevel())));
        } catch (Exception ex) {
            throw new CLIException(ex.getMessage());
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
                "search [1|2|3] (Suche nach Expertisen) \n\n" +
                "exit (Verlassen der Anwendung)\n\n" +
                "help (Anzeige aller möglichen Befehle)\n\n");
    }

}