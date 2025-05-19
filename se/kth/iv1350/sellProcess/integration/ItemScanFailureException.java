package se.kth.iv1350.sellProcess.integration;

public class ItemScanFailureException extends  Exception{

    public ItemScanFailureException(String itemID) {
        super("Varan " + itemID + " kunde ej skannas. Vänligen försök igen.");
    }


}
