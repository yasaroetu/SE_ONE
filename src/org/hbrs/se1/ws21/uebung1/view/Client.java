package org.hbrs.se1.ws21.uebung1.view;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		//
		// Strenge Implementierung gegen das Interface Translator gewuenscht!
		System.out.println("Das Ergebnis der Berechnung: " +
				TranslatorFactory.createGermanTranslator().translateNumber(aNumber)  );
	}
}
