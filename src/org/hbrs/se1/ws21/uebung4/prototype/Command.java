package org.hbrs.se1.ws21.uebung4.prototype;

public interface Command {

    public void execute();

    void undo();
}
