package se.kth.iv1350.sellProcess.integration;

public class InvalidInputException extends Exception{
    private InvalidInput type;
    private Object info;

      public InvalidInputException(InvalidInput type, Object info){
        super(invalidInput(type,info));
        this.type = type;
        this.info = info;
        

      }

    public InvalidInputException() {
    }

      


      private static String invalidInput (InvalidInput type, Object info){

        return switch(type){

            case NO_POS_INT -> {
              double antal = (double)info;
              yield antal + " felaktigt angivet som varuantal. Logg sparad.";

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
