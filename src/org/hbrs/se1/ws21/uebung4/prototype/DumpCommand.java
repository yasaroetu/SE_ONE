package org.hbrs.se1.ws21.uebung4.prototype;

public class DumpCommand implements Command {
    @Override
    public void execute() {
        Container.getInstance().getCurrentList();
        // --> EmployeeView aufrufen...
    }

    @Override
    public void undo() {

    }
}
