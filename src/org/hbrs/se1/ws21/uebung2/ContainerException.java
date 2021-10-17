package org.hbrs.se1.ws21.uebung2;

public class ContainerException extends Exception{
    ContainerException(Integer id) {
        super("Das Member-Objekt mit der ID " + id + " ist bereits vorhanden!");
    }
}
