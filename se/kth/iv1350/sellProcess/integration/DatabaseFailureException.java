package se.kth.iv1350.sellProcess.integration;

/*
 * Creates a new instance simulating database not found.
 * 
 * @param itemID    relates to the itemcode that is to be scanned
 * 
 * 
 */

public class DatabaseFailureException extends Exception {

    public DatabaseFailureException(String itemdID) {
        super("Kunde inte ansluta till databasen med artikelnummer: " + itemdID +".");
    }
}
