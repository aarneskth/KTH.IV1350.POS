package se.kth.iv1350.sellProcess.integration;

/*
 * Creates a new instance simulating the amount of the scanned item is 0 according to the inventory.
 * 
 * @param itemID    relates to the itemcode that is to be scanned
 * 
 */

public class InsufficentStockException extends Exception{

 
      public InsufficentStockException(String itemID){
        super("Lagerstatus negativt efter registrering av varan: " +"\"" + itemID +"\"" + " Korigera lagerstatus." );
        

      }
     
}



