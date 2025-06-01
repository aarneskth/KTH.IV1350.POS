package se.kth.iv1350.sellProcess.integration.DTO;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import se.kth.iv1350.sellProcess.model.Item;

/*
 * 
 * SaleDTO stores details about the sale 
 */

public class SaleDTO {
    private double VAT;
    private double totalPrice;
    private double discount;
    private List<Item> itemList;
    private LocalDateTime timeOfSale = LocalDateTime.now();
    private double totalPriceBeforeDiscount;

    /*
     * Creates a new instance, representing most of the the sale info as parameters
     * in Sale.
     * 
     * @param VAT The VAT is the total amount of tax in the sale
     * totalPrice TotalPrice represents the total cost for the sale, including tax.
     * discount Discount tells the sum of the disocunt in sale
     * itemList This is the list of all the items in Sale.
     * 
     */
    public SaleDTO(double VAT, double totalPrice, double discount, List<Item> itemList, double totalPriceBeforeDiscount) {

        this.VAT = VAT;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.itemList = Collections.unmodifiableList(itemList);
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public double getVAT() {
        return this.VAT;
    }

    public LocalDateTime getTimeOfSale() {
        return timeOfSale;
    }

    public double getDiscount() {
        return this.discount;
    }

    public List<Item> getAllItems() {
        return itemList;
    }

    public double getTotalPriceBeforeDiscount(){
        return totalPriceBeforeDiscount;
    }

}
