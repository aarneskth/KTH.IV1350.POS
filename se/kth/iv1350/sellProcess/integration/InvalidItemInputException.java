package se.kth.iv1350.sellProcess.integration;

public class InvalidItemInputException extends Exception {

    public InvalidItemInputException(String itemID, double itemAmount) {

        super("Varukoden" + "\"" + itemID + "\"" +"  finns inte i databasen eller antalet " + itemAmount + " ogiltigt angivet vid skanning." );
    }

     private InvalidInput type;
    private Object info;

      public InvalidItemInputException(InvalidInput type, Object info){
        super(itemCantBeReg(type,info));
        this.type = type;
        this.info = info;
        

      }

    public InvalidItemInputException() {
    }

      


      private static String itemCantBeReg (InvalidInput type, Object info){

        return switch(type){

            case NO_POS_INT -> {
              
              yield info + " är ett ogiltigt antal. Vänlig korrigera varuantalet.";

            }
            case ID_NOT_FOUND -> {
              String itemID = (String) info;
              yield "Varukoden" + "\"" + itemID + "\" finns inte i databasen. Varan är ej registrerad, måste registreras manuellt. ";
            }
            
        };

      }
}


