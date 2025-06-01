package se.kth.iv1350.sellProcess.integration;

import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;

/**
 * Represents an item stored in the external inventory system and the amount of that item.
 */

public class InventoryObject {
    private final ItemDTO itemDTO;
    private int inventoryItemAmount;

        /**
     * Creates a new instance representing an item in the inventory,
     * including the item's details and its available quantity.
     *
     * @param itemDTO               The DTO containing all information about the item.
     * @param inventoryItemAmount   The quantity of the item available in the inventory.
     */

    public InventoryObject(ItemDTO itemDTO, int inventoryItemAmount) {
        this.itemDTO = itemDTO;
        this.inventoryItemAmount = inventoryItemAmount;
    }

    public ItemDTO getItemDTO(){
        return itemDTO;
    }

    public int getItemAmount(){
        return inventoryItemAmount;
    }

    public void setNewAmount(int boughtAmount){
        this.inventoryItemAmount = this.inventoryItemAmount - boughtAmount;
    }
}
