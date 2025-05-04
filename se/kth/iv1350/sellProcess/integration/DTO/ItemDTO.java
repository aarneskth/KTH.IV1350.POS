package se.kth.iv1350.sellProcess.integration.DTO;

public class ItemDTO {

    private String itemName;
    private double itemPrice;
    private double itemVATRate;
    private String itemID;

        /*
     *  Creates a new instance, representing the parameters in itemDTO
     * 
     *  @param itemName     The name of the item
     *         totalPrice   The total cost of the item.
     *         itemVATrate  The VAT rate of the item
     *         itemID       Represents the bar code simplyfied as a string.     
     * 
     */

    public ItemDTO(String itemName, double itemPrice, double itemVATRate, String itemID) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemVATRate = itemVATRate;
        this.itemID = itemID;
    }

    public double getPrice() {
        return itemPrice;
    }

    public double getItemVatRate() {
        return itemVATRate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getitemID() {

        return itemID;
    }
}
