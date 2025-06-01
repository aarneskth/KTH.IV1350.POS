package se.kth.iv1350.sellProcess.integration;

import java.util.HashMap;
import java.util.Map;
import se.kth.iv1350.sellProcess.integration.DTO.*;
import se.kth.iv1350.sellProcess.model.Item;


public class ExternalInventorySystem {

    private final Map<String, InventoryObject> inventory = new HashMap<>();
    private static final ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();  

  /*
   * Creates an instance that creates the items in the inventory system.
   * 
   */
    private ExternalInventorySystem(){

        String ost = "OST123";
        String honung = "HON123";
        String äpplen = "APP123";
        String sparris = "SPA123";
        String knäckebröd = "KNA123";
        inventory.put(äpplen, new InventoryObject (new ItemDTO("Äpplen",14.90,0.12,äpplen, "Aroma 1 kg"),10));
        inventory.put(honung, new InventoryObject (new ItemDTO("Honung",89.90,0.12,honung, "svensk"),35));
        inventory.put(ost, new InventoryObject (new ItemDTO("Ost",59.90,0.12,ost, "Saint Agur"),15));
        inventory.put(sparris, new InventoryObject (new ItemDTO("Sparris",32.90,0.12,sparris, "grön"),4));
        inventory.put(knäckebröd, new InventoryObject (new ItemDTO("Bröd",37.50,0.12,knäckebröd, "fäbodknäcke"),20));
    }

    /*
    * getItem               Representing the process of getting all the info about an item from
                            the item inventory.
    * @param itemID        Representing the barcode on the item for scanning the item.
    * @param itemAmount    The amount of the specific item to be scanned.
    * 
     * @throws InvalidInputException        Throws an exception if the itemID is not found, or if 
     *                                      the item amount is typed wrongly like 0 or -1.
     *                                      The Exception has two enums that the case of not ID from
     *                                      the case of wrongly typed item amount.  
     * @throws DatabaseFailureException     Throws an exception if the inventory database is 
     *                                      not found. 
    */

    public ItemDTO getItem(String itemID, int itemAmount) throws InvalidInputException, DatabaseFailureException {

            if("DataBasFel123".equals(itemID)){

                throw new DatabaseFailureException(itemID);
            }
        
            if(itemAmount <= 0){

                throw new InvalidInputException (InvalidInput.NO_POS_INT, itemAmount);
            }

            if(!inventory.containsKey(itemID)){

                throw new InvalidInputException(InvalidInput.ID_NOT_FOUND, itemID);
            }

            inventory.get(itemID).setNewAmount(itemAmount);
            
           return inventory.get(itemID).getItemDTO();
        }
        

    
    /*
     * UpdateInventory      Uppdates the list of items available in the store.
     * 
     * @param saleInfo      Saleinfo contains information about what items and how many that are removed or added to the inventory/store. 
     */

    public void updateInventory(SaleDTO saleInfo) {
        
    for (Item soldItem : saleInfo.getAllItems()) {
        String itemID = soldItem.getItemID();
        int amountSold = soldItem.getItemAmount();

        ItemDTO itemInInventory = inventory.get(itemID).getItemDTO();
        if (itemInInventory != null) {
        }
    }
}

public static ExternalInventorySystem getExternalInventorySystem() {

    return externalInventorySystem;
}


}
