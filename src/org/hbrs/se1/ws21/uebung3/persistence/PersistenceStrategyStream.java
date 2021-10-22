package org.hbrs.se1.ws21.uebung3.persistence;

import java.awt.print.PrinterException;
import java.io.*;

import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {


    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save
     */
    public void openConnection() throws PersistenceException {
        /*try {
            if(this.iStream != null || this.oStream != null)
                throw new PersistenceException(PersistenceException.ExceptionType.IOException,"Connection is still open!");
            new FileOutputStream(this.location).
            if(!(new File(this.location).exists()))
                new File(this.location).createNewFile();
            this.oStream = new FileOutputStream(this.location);
            this.iStream = new FileInputStream(this.location);

        } catch(Exception ex) {
            throw new PersistenceException(PersistenceException.ExceptionType.IOException,ex.getMessage());
        }*/
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        /*try {
            if(this.iStream == null || this.oStream == null)
                throw new PersistenceException(PersistenceException.ExceptionType.IOException,"There is no stream to close!");

            this.iStream.close();
            this.oStream.close();
            this.iStream = null;
            this.oStream = null;

        } catch(Exception ex) {
            throw new PersistenceException(PersistenceException.ExceptionType.IOException,ex.getMessage());
        }*/
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException  {
        try {
            FileOutputStream oStream = new FileOutputStream(this.location);
            ObjectOutputStream oOStream = new ObjectOutputStream(oStream);
            oOStream.writeObject(member);
            oOStream.close();
            oStream.close();
        } catch(Exception ex) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,ex.getMessage());
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<Member> load() throws PersistenceException  {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
        List<Member> member = null;
        try {
            FileInputStream iStream = new FileInputStream(this.location);
            ObjectInputStream iOStream = new ObjectInputStream(iStream);
            member = (List<Member>)iOStream.readObject();
            iOStream.close();
            iStream.close();

        } catch(Exception ex) {
            throw new PersistenceException(PersistenceException.ExceptionType.ConnectionNotAvailable,ex.getMessage());
        }

        return member;
    }
}
