package se.kth.iv1350.sellProcess.integration;

/*
 * Creates a new instance simulating database not found.
 * 
 * @param type    An enum that explains the condition of the exception
 * @param info    An object that can take both the item amount or the itemID.
 * 
 * 
 */

public class InvalidInputException extends Exception{
    private InvalidInput type;
    private Object info;

      public InvalidInputException(InvalidInput type, Object info){
        super(invalidInput(type,info));
        this.type = type;
        this.info = info;
        

      }

  /*
 * invalidInput   Checks what kind of errormessage that is related to the exception.
 * 
 * @param type    An enum that explains the condition of the exception
 * @param info    An object that can take both the item amount or the itemID.
 * 
 * 
 */


      private static String invalidInput (InvalidInput type, Object info){

        return switch(type){

            case NO_POS_INT -> {
              
              yield info + " felaktigt angivet som varuantal. Vara ej skannad.";

            }
            case ID_NOT_FOUND -> {
              String itemID = (String) info;
              yield "Varan med ID:nummret \"" + itemID + "\" kunde ej hittas i databasen.";
            }
            
            
        };

      }

      public InvalidInput getReason(){

        return this.type;
      }


      public Object getObjects(){

        return this.info;
      }

    
}
