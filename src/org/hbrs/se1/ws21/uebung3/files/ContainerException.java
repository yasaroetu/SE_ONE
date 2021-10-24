package org.hbrs.se1.ws21.uebung3.files;

public class ContainerException extends Exception{
    ContainerException(Integer id) {
        super("Das Member-Objekt mit der ID " + id + " ist bereits vorhanden!");
    }
}
