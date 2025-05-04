package se.kth.iv1350.sellProcess.integration;

import java.util.HashMap;
import java.util.Map;

import se.kth.iv1350.sellProcess.model.Item;
import se.kth.iv1350.sellProcess.integration.DTO.*;;


public class ExternalInventorySystem {
    //private Item inventory;
    //private ItemDTO iteminfo;

    private final Map<String, ItemDTO> invnetory = new HashMap<>();
        

  /*
   * Creates an instance that creates the items in the inventory system.
   * 
   */
    public ExternalInventorySystem(){

        String köttbulle = "KOTT123";
        String honung = "Hon123";
        String apple = "APP123";
        invnetory.put(apple, new ItemDTO("ÄPPLE",2,0.12,apple));
        invnetory.put(honung, new ItemDTO("HONUNG",54.90,0.12,honung));
        invnetory.put(köttbulle, new ItemDTO("KÖTTBULLE",28.90,0.12,köttbulle));
        //inventory = new Item(new ItemDTO("honung",54.90,1.13,honung));
        //inventory = new Item(new ItemDTO("äpplen",2,1.12,apple));
        //invnetory.get(apple);

    }

    public ItemDTO getItem(String itemID){


       return invnetory.get(itemID);
        
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
