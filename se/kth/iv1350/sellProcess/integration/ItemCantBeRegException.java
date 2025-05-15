package se.kth.iv1350.sellProcess.integration;

public class ItemCantBeRegException extends Exception{
    private ItemCantBeReg type;
    private Object info;

      public ItemCantBeRegException(ItemCantBeReg type, Object info){
        super(itemCantBeReg(type,info));
        this.type = type;
        this.info = info;
        

      }


      private static String itemCantBeReg (ItemCantBeReg type, Object info){

        return switch(type){

            case NO_POS_INT -> {
              int antal = (Integer)info;
              yield antal + " är ett ogiltigt antal. Registreras ej";

            }
            case ID_NOT_FOUND -> {
              String itemID = (String) info;
              yield "Varan med ID:nummret \"" + itemID + "\" kunde ej hittas. Ej registrerad.";
            }

            
        };

      }
}
