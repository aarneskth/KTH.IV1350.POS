package se.kth.iv1350.sellProcess.integration.DTO;

public class ItemDTO {

    private final String itemName;
    private final double itemPrice;
    private final double itemVATRate;
    private final String itemID;
    private final String itemInfo;

    /*
     *  Creates a new instance, representing the parameters in itemDTO
     * 
     *  @param itemName     The name of the item
     *         totalPrice   The total cost of the item.
     *         itemVATrate  The VAT rate of the item
     *         itemID       Represents the bar code simplyfied as a string.     
     * 
     */

    public ItemDTO(String itemName, double itemPrice, double itemVATRate, String itemID, String itemInfo) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemVATRate = itemVATRate;
        this.itemID = itemID;
        this.itemInfo = itemInfo;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getItemVatRate() {
        return itemVATRate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemID() {

        return itemID;
    }
    
    public String getItemInfo() {

        return itemInfo;
    }
}
