package se.kth.iv1350.sellProcess.integration;

import java.util.HashMap;
import java.util.Map;
import se.kth.iv1350.sellProcess.integration.DTO.*;


public class ExternalInventorySystem {
    //private Item inventory;
    //private ItemDTO iteminfo;

    private final Map<String, ItemDTO> inventory = new HashMap<>();
        

  /*
   * Creates an instance that creates the items in the inventory system.
   * 
   */
    public ExternalInventorySystem(){

        String köttbullar = "KOTT123";
        String honung = "HON123";
        String äpplen = "APP123";
        inventory.put(äpplen, new ItemDTO("Äpplen",2,0.12,äpplen, "Aroma 1 kg"));
        inventory.put(honung, new ItemDTO("Honung",54.90,0.12,honung, "Bigården svensk 300 gram"));
        inventory.put(köttbullar, new ItemDTO("Köttbullar",28.90,0.12,köttbullar, "Änglamark 600 gram"));
    }

    public ItemDTO getItem(String itemID, int itemAmount) throws ItemCantBeRegException {

            if(itemAmount <= 0 || itemAmount%1 !=0){

                throw new ItemCantBeRegException (ItemCantBeReg.NO_POS_INT,itemAmount);
            }
            if(!inventory.containsKey(itemID)){
                throw new ItemCantBeRegException (ItemCantBeReg.ID_NOT_FOUND,itemID);
            }

            
           return inventory.get(itemID);
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

    public void updateInventory(SaleDTO saleinfo)
    {
        

    }

   

}
