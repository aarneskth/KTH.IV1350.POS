package se.kth.iv1350.sellProcess.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;
import se.kth.iv1350.sellProcess.integration.DTO.PriceBeforeDiscountDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.view.SaleObserver;

public class Sale {
    double discount;
    double VAT;
    double totalPriceFinal;
    List<Item> itemList;
    private SaleDTO theSale;
    private Item item;
    private List<SaleObserver> observers = new ArrayList<>();
    private double totalRevenue;
    private double totalPriceBeforeDiscount;

    /*
     * creates a new instance, Represents the Sale at the point of sale in a retail
     * store.
     *
     */

    public Sale() {

        itemList = new ArrayList<>();
    
        
    }

       private void notifyObserver(){
        for (SaleObserver obs : observers){
            obs.sumUpSale(this.totalRevenue);
        }
    }

    public void addObserver(SaleObserver observer){
        observers.add(observer);
    }

    /*
     * printreceipt Prints the receipt of the sale.
     * 
     * @param printer representing the printing machine for the receipe.
     */

    public void printReceipt(Printer printer, PayedAmount payedAmount) {

        calculateTotalVAT();
        calculateTotalPriceWithVAT(); 
        SaleDTO saleInfo = getSaleInfo();
        Receipt receipt = new Receipt(saleInfo);
        this.totalRevenue+=saleInfo.getTotalPrice();
        printer.printReceipt(receipt, payedAmount);
        notifyObserver();

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

    public PriceBeforeDiscountDTO createPriceBeforeDisocuntDTO(){


        calculateTotalPriceNoVAT();
        PriceBeforeDiscountDTO price = new PriceBeforeDiscountDTO(totalPriceBeforeDiscount, VAT);

        return price;
    }


    public SaleDTO getSaleInfo() {

        if(totalPriceFinal < 0)
        {
            totalPriceFinal = 0;
        }
    
        
        theSale = new SaleDTO(VAT, totalPriceFinal, discount, itemList, totalPriceBeforeDiscount);
        return theSale;
    }

    /*
     * calcylateTotalVAT        Gives the total amount of tax in SEK for all items scanned.
     * 
     */

    public double calculateTotalVAT() {
        VAT = 0;
        for (Item item : itemList) {

            VAT += item.getVatRate() * item.getPrice();
        }

        return VAT;
    }

    /*
     * alculateTotalPriceWithVat    Gives info about the total cost for the customer for 
     *                              buying the goods
     * 
     */

     public double calculateTotalPriceNoVAT() {
         totalPriceBeforeDiscount = 0;
        for (Item item : itemList) {

             totalPriceBeforeDiscount+= item.getPrice();
        }

        return  totalPriceBeforeDiscount;

     }

    public double calculateTotalPriceWithVAT() {
        totalPriceFinal = 0;
        for (Item item : itemList) {

            totalPriceFinal += item.getPrice();
        }
        
        totalPriceFinal = (VAT + totalPriceFinal) - discount;
        System.out.println("");
        return totalPriceFinal;
    }

    public void setDiscount(double discount)
    {   
        this.discount = discount;
    }

}
