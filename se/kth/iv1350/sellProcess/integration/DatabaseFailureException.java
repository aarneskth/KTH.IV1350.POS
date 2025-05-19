package se.kth.iv1350.sellProcess.integration;

public class DatabaseFailureException extends Exception {

    public DatabaseFailureException(String itemdID) {
        super("Kunde inte ansluta till databasen med artikelnummer: " + itemdID +".");
    }
}
