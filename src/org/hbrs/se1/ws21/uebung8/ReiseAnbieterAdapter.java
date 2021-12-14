package org.hbrs.se1.ws21.uebung8;

import java.util.ArrayList;

public class ReiseAnbieterAdapter implements ReiseAnbieter {

    ArrayList<QueryResult> qr = new ArrayList<>();

    public ReiseAnbieterAdapter() {
        qr.add(new QueryResult("Schweiz"));
        qr.add(new QueryResult("Deutschland"));
        qr.add(new QueryResult("Spanien"));
        qr.add(new QueryResult("England"));
        qr.add(new QueryResult("Frankreich"));
        qr.add(new QueryResult("Polen"));
        qr.add(new QueryResult("Niederlande"));
        qr.add(new QueryResult("Österreich"));
    }

    public Suchergebnis suche(Suchauftrag s) {
        return this.convertOUT(this.executeQuery(this.convertIN(s)));
    }

    public QueryResult executeQuery(QueryObject q) {
        QueryResult r = null;
        for(QueryResult c : qr) {
            if(c.getName().equals(q.getName())) {
                r = c;
                break;
            }
        }
        return r;
    }

    private QueryObject convertIN(Suchauftrag s) {
        return new QueryObject(s.getBeschreibung());
    }
    private Suchergebnis convertOUT(QueryResult q) {
        return new Suchergebnis(q.getName());
    }
}
