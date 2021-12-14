package org.hbrs.se1.ws21.demo.kapitel4;

public class Client {
	
	/**
	 *
	 * @author sascha
	 * Die Klasse Client hat eine Abhänigkeit zur Klasse Application.
	 * Diese kann aus drei Gruenden bestehen:
	 * 1. Abhängigkeit über eine Instanzvariable (Abhängigkeit Nr. 1)
	 * 2. Abhängigkeit über einer lokalen Variable innerhalb einer Methode (Abhängigkeit Nr. 2)
	 * 3. Abhängigkeit über ein statisches Element (hier: eine statische Methode) (Abhängigkeit Nr. 3)
	 */
    
    // Abhängigkeit Nr. 1
    private Application app;
    
    public void print() {
        // Abhängigkeit Nr. 2
        Application app;
        
        // Abhängigkeit Nr. 3
        Application.log();
        
    }
    
}
