package se.kth.iv1350.sellProcess.integration;

public class IllegalAmountException extends Exception{
    private IllegalAmount type;

      public IllegalAmountException(IllegalAmount type){
        super(itemCantBeReg(type));
        this.type = type;
        

      }


      private static String itemCantBeReg (IllegalAmount type){

        return switch(type){

            case NONPOSITIVE -> "Ogiltigt antal av varan. Ingen vara registrerad.";
            case IDNOTFOUND -> "Varan kan ej hittas. Ej registrerad.";
        };

      }
}
