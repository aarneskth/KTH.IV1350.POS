package se.kth.iv1350.sellProcess.integration;

/*
 * Creates a new instance simulating database not found.
 * 
 * @param type    An enum that explains the condition of the exception
 * @param info    An object that can take both the item amount or the itemID.
 * 
 */

public class InvalidItemInputException extends Exception {

     private InvalidInput type;
    private Object info;

      public InvalidItemInputException(InvalidInput type, Object info){
        super(itemCantBeReg(type,info));
        this.type = type;
        this.info = info;
      }

/*
 * itemCantBeReg   Checks what kind of errormessage that is related to the exception.
 * 
 * @param type    An enum that explains the condition of the exception
 * @param info    An object that can take both the item amount or the itemID.
 * 
 * 
 */


      private static String itemCantBeReg (InvalidInput type, Object info){

        return switch(type){

            case NO_POS_INT -> {
              
              yield info + " är ett ogiltigt antal. Vänlig korrigera varuantalet.";

            }
            case ID_NOT_FOUND -> {
              String itemID = (String) info;
              yield "Varukoden" + "\"" + itemID + "\" finns inte i databasen. Varan är ej registrerad. ";
            }
            
        };

      }
}


