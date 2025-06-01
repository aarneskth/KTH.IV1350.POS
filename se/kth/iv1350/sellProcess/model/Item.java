package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;

public class Item {

    /*
     * private final ItemDTO itemDTO;
     * private int quanitiy;
     */

    private final String itemName;
    private final double price;
    private final double vatRate;
    private final int amount;
    private final ItemDTO itemDTO;
    private final String itemID;
    private final String itemInfo;

    /*
     * Creates a new instance, which represents a specific product.
     *
     * @param itemDTO Contains all the informationa a certain item.
     * itemAmount tells about the number of the same type of item registered
     * togheter.
     */

    public Item(ItemDTO itemDTO, int itemAmount) {

        this.itemName = itemDTO.getItemName();
        this.price = itemDTO.getItemPrice();
        this.vatRate = itemDTO.getItemVatRate();
        this.amount = itemAmount;
        this.itemDTO = itemDTO;
        this.itemID = itemDTO.getItemID();
        this.itemInfo = itemDTO.getItemInfo();

    }

    public ItemDTO getItemDTO() {

        return this.itemDTO;
    }

    public String getName() {

        return itemName;
    }

    public double getPrice() {
        double pris = 0;
        pris = price * getItemAmount(); 
        return pris;
    }

    public double getVatRate() {

        return vatRate;
    }

    public String getItemID() {

        return itemID;
    }

    public int getItemAmount() {

        return amount;
    }

    public String getItemInfo() {
        
        return itemInfo;
    }

    @Override
    public String toString() {
    return String.format(
        "%s (%s), antal: %d, pris/st: %.2f kr, totalt: %.2f kr",
        itemDTO.getItemName(),
        itemDTO.getItemInfo(),
        amount,
        itemDTO.getItemPrice(),
        getPrice()
    );
}

}
