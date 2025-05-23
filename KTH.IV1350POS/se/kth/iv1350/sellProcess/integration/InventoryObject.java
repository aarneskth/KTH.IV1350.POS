package se.kth.iv1350.sellProcess.integration;

import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;

public class InventoryObject {
    private final ItemDTO itemDTO;
    private int inventoryItemAmount;

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
