package se.kth.iv1350.sellProcess.integration;

import java.util.HashMap;
import java.util.Map;
import se.kth.iv1350.sellProcess.integration.DTO.*;
import se.kth.iv1350.sellProcess.model.Item;


public class ExternalInventorySystem {
    //private Item inventory;
    //private ItemDTO iteminfo;

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
        inventory.put(äpplen, new InventoryObject (new ItemDTO("Äpplen",14.90,0.12,äpplen, "Aroma 1 kg"),10));
        inventory.put(honung, new InventoryObject (new ItemDTO("Honung",54.90,0.12,honung, "svensk"),35));
        inventory.put(ost, new InventoryObject (new ItemDTO("Ost",49.90,0.12,ost, "Saint Agur"),15));
        inventory.put(sparris, new InventoryObject (new ItemDTO("Sparris",27.90,0.12,sparris, "grön"),4));
    }

    public ItemDTO getItem(String itemID, int itemAmount) throws InvalidInputException, DatabaseFailureException, InsufficentStockException {

            if("DataBasFel123".equals(itemID)){

                throw new DatabaseFailureException(itemID);
            }
        
            if(itemAmount <= 0 || itemAmount%1 !=0){

                throw new InvalidInputException (InvalidInput.NO_POS_INT, itemAmount);
            }

            if(!inventory.containsKey(itemID)){

                throw new InvalidInputException(InvalidInput.ID_NOT_FOUND, itemID);
            }

            if(itemAmount > inventory.get(itemID).getItemAmount())
            {
                throw new InsufficentStockException(itemID);
            }
            inventory.get(itemID).setNewAmount(itemAmount);
            
           return inventory.get(itemID).getItemDTO();
        }
        

    private  boolean itemInInventory(String itemID){
        
        if(inventory.get(itemID) != null){
        return true;
        }
        
        return false;
    }

    
    /*
     * UpdateInventory      Uppdates the list of items available in the store.
     * 
     * @param saleInfo      Saleinfo contains information about what items and how many that are removed or added to the inventory/store. 
     */

    public void updateInventory(SaleDTO saleInfo) {
        
    for (Item soldItem : saleInfo.getAllItems()) {
        String itemID = soldItem.getItemID();
        int amountSold = soldItem.itemGetAmount();

        ItemDTO itemInInventory = inventory.get(itemID).getItemDTO();
        if (itemInInventory != null) {
        }
    }
}

public static ExternalInventorySystem getExternalInventorySystem() {

    return externalInventorySystem;
}


}
