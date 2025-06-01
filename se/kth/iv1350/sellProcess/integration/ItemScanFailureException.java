package se.kth.iv1350.sellProcess.integration;

  /*
 * Creates a new instance simulating failing registrating the item
 * 
 * @param itemID    relates to the itemcode that is to be scanned
 * 
 * 
 */

public class ItemScanFailureException extends  Exception{

    public ItemScanFailureException(String itemID) {
        super("Varan " + itemID + " kunde ej skannas. Vänligen försök igen.");
    }


}
