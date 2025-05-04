package se.kth.iv1350.sellProcess.controller;

import se.kth.iv1350.sellProcess.model.*;
import se.kth.iv1350.sellProcess.integration.DTO.*;
import se.kth.iv1350.sellProcess.integration.*;

public class Controller {
    private Printer printer;
    private ExternalInventorySystem inventorySystem;
    private ExternalAccountingSystem accountingSystem;
    // private Sale sale;
    private Discount discount;

    Sale sale = new Sale();
    // private List<Item> itemList;

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
        // this.sale= sale;
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

    public void scanItem(String itemID, int itemAmount) {

        if (sale == null) {
            System.out.println("Ingen aktiv försäljning.");
            return;
        }
        sale.scanitem(itemID, itemAmount);

        /*
         * ItemDTO glass = new ItemDTO(itemID, itemAmount, itemAmount, itemID);
         * 
         * ItemDTO ItemDTO = inventorySystem.getItem(itemID);
         * Item apple = new Item(ItemDTO,2);
         */
    }

    public void pay(PayedAmount payedAmount) {

        sale.printReceipt(printer, payedAmount);
    }

    public void checkDiscount(SaleDTO saleDTO, boolean membershipStatus) {

    }

    public boolean checkMembershipStatus(String customerName, int customerID) {

        return true;
    }

    public SaleDTO getSaleInfo(SaleDTO saleinfoDto) {

        return saleinfoDto;
    }

    public void endsale() {
        System.out.println("Försäljningen är avslutad.");
        sale = null;

    }

}
