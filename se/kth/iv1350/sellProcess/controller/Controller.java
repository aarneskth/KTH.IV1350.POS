package se.kth.iv1350.sellProcess.controller;

import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.integration.DTO.*;
import se.kth.iv1350.sellProcess.model.*;
import se.kth.iv1350.sellProcess.view.SaleObserver;

public class Controller {
    private Printer printer;
    private ExternalInventorySystem inventorySystem;
    private ExternalAccountingSystem accountingSystem;
    private CustomerMembershipRegister membershipRegister;
    private Discount discount;

    Sale sale = new Sale();

    /*
     * creates a new instance, Represents the Con you get as a proof of the payment.
     * 
     * @param saleinfo representing the information of the sale including the list
     * of items, total price etc.
     */

    public Controller(Printer printer, ExternalInventorySystem inventorySystem,
            ExternalAccountingSystem accountingSystem) {

        this.printer = printer;
        this.inventorySystem = inventorySystem;
        this.accountingSystem = accountingSystem;
        this.discount = new Discount();
        this.membershipRegister = new CustomerMembershipRegister();
    }

    public void startSale() {

        this.sale = new Sale();
    }

    /*
     * public void registrerItemID(String itemName, double itemPrice, double
     * itemVATRate, String itemID) {
     * 
     * //double vatrate = 0.13;
     * sale.additem(itemName, itemPrice, itemVATRate, itemID);
     * 
     * 
     * }
     */

    public Item scanItem(String itemID, int itemAmount) throws ItemCantBeRegException{
          

      ItemDTO itemDTO = inventorySystem.getItem(itemID, itemAmount);
        return sale.scanitem(itemDTO, itemAmount); //lagt till retur+extinvsys /*, inventorySystem*/
    }

        /*
         * ItemDTO glass = new ItemDTO(itemID, itemAmount, itemAmount, itemID);
         * 
         * ItemDTO ItemDTO = inventorySystem.getItem(itemID);
         * Item apple = new Item(ItemDTO,2);
         */

    public void pay(PayedAmount payedAmount) {

        sale.printReceipt(printer, payedAmount);
    }

    public void checkDiscount(boolean membershipStatus) {
        SaleDTO saleInfo = sale.getSaleInfo();
        double discountAmount = discount.checkDiscount(saleInfo, membershipStatus);
        sale.setDiscount(discountAmount);
        sale.calculateTotalPriceWithVat();
    }

    public boolean checkMembershipStatus(String customerName, String customerID) {

        return membershipRegister.checkMembershipStatus(customerName, customerID);
    }

    public SaleDTO getSaleInfo() {
        return sale.getSaleInfo();
    }

    public String getKvitto(){

        return printer.getKvitto();
    }

    public void addSaleObserver(SaleObserver obs){
        sale.addObserver(obs);
    }

        public void endsale() {
        //sale = null;

    }
}


