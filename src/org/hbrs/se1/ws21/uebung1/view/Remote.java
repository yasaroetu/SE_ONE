package org.hbrs.se1.ws21.uebung1.control;
package org.hbrs.se1.ws21.uebung1.view;

public class Remote {
    public static Object translateNumber(int number) {
        return new GermanTranslator().translateNumber(number);
    }
}