package org.hbrs.se1.ws21.uebung1.view;
import org.hbrs.se1.ws21.uebung1.control.GermanTranslator;


public class TranslatorFactory {
    public static String translateNumber_German(int number) {
        return new GermanTranslator().translateNumber(number);
    }
}