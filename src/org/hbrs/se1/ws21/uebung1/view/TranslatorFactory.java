package org.hbrs.se1.ws21.uebung1.view;
import org.hbrs.se1.ws21.uebung1.control.*;


public class TranslatorFactory {
    public static Translator createGermanTranslator() {
        return new GermanTranslator();
    }
}