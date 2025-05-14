package se.kth.iv1350.sellProcess.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

public class Sale {
    double discount;
    double VAT;
    double totalPrice;
    List<Item> itemList;
    private SaleDTO itemBuy;
    private Item item;
    private ItemDTO itemDTO;

    /*
     * creates a new instance, Represents the Sale at the point of sale in a retail
     * store.
     *
     */

    public Sale() {

        itemList = new ArrayList<>();
    }

    /*
     * printreceipt Prints the receipt of the sale.
     * 
     * @param printer representing the printing machine for the receipe.
     */

    public void printReceipt(Printer printer, PayedAmount payedAmount) {

        calculateTotalVAT();
        calculateTotalPriceWithVat();
        SaleDTO saleInfo = getSaleInfo();
        Receipt receipt = new Receipt(saleInfo);
        printer.printReceipt(receipt, payedAmount);

    }

        /*
     * scanItem  the method represents the process of scanning an item at the POS where the cashier
     *           also could enter the amount of items to buy.
     * 
     * @param itemID    itemID is the code that the cashier scans/enters to get the item information
     *                  from the external inventory system.
     * 
     * @param itemAmount tells the amount of the certain item just to be scanned. 
     */

    public Item scanitem(ItemDTO itemDTO, int itemAmount) { // tog bort ExternalSystemInevntory

            item = new Item(itemDTO, itemAmount);
            itemList.add(item);

        return item;
    }


    public SaleDTO getSaleInfo() {

        itemBuy = new SaleDTO(VAT, totalPrice, discount, itemList);

        return itemBuy;
    }

    /*
     * calcylateTotalVAT        Gives the total amount of tax in SEK for all items scanned.
     * 
     */

    public double calculateTotalVAT() {

        for (Item item : itemList) {

            VAT += item.getVatRate() * item.getPrice();
        }

        return VAT;
    }

        /*
     * alculateTotalPriceWithVat    Gives info about the total cost for the customer for 
     * buying the goods
     * 
     */

    public double calculateTotalPriceWithVat() {

        for (Item item : itemList) {

            totalPrice += item.getPrice();
        }

        totalPrice = (VAT) + totalPrice;
        return totalPrice;
    }

/*
    private ItemDTO getItem(String itemID) {
        switch (itemID) {
            case "GLASS123":
                return new ItemDTO("Glass", 10, 0.12, "GLASS123");
            case "MJÖLK123":
                return new ItemDTO("Mjölk", 20, 0.12, "MJÖLK123");
            case "AVAKADO123":
                return new ItemDTO("AVACADO", 10, 0.12, "AVACADO123");

            default:
                return null;
        }

    }
*/
}
