package se.kth.iv1350.sellProcess.integration;


public class InsufficentStockException extends Exception{

 
      public InsufficentStockException(String itemID){
        super("Lagerstatus negativt efter registrering av varan: " +"\"" + itemID +"\"" + " Korigera lagerstatus." );
        

      }
     
}



