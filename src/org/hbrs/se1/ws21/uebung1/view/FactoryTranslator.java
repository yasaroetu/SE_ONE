package org.hbrs.se1.ws21.uebung1.view;
import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;


public class FactoryTranslator {
    public static String translateNumber(int number) {
        return new GermanTranslator().translateNumber(number);
    }
}