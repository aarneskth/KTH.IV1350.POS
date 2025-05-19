package se.kth.iv1350.sellProcess.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
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
    private ItemDTO itemDTO;
    private static final FileLogger logger = new FileLogger();
    private static final ExternalInventorySystem externalInventorySystem = ExternalInventorySystem.getExternalInventorySystem();


    Sale sale = new Sale();

    /*
     * creates a new instance, Represents the Con you get as a proof of the payment.
     * 
     * @param saleinfo representing the information of the sale including the list
     * of items, total price etc.
     */

    public Controller(Printer printer, 
            ExternalAccountingSystem accountingSystem) {

        this.printer = printer;
        //this.inventorySystem = inventorySystem;
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

    public Item scanItem(String itemID, int itemAmount) throws ItemScanFailureException, InvalidItemInputException{



        try {
            this.itemDTO = externalInventorySystem.getItem(itemID, itemAmount);

        } catch (InvalidInputException regException) {

            StringWriter papper = new StringWriter();
            PrintWriter penna = new PrintWriter(papper);
            regException.printStackTrace(penna);
            String  stachTraceString = papper.toString();
            logger.log(regException.getMessage() +" \n" + stachTraceString);
          
            throw new InvalidItemInputException(regException.getReason(),regException.getObjects());

        }catch(InsufficentStockException insufficentStock){

            StringWriter papper = new StringWriter();
            PrintWriter penna = new PrintWriter(papper);
            insufficentStock.printStackTrace(penna);
            String  stachTraceString = papper.toString();
            logger.log (insufficentStock.getMessage() +" \n" + stachTraceString);

        } catch(DatabaseFailureException databaseFailure){

            StringWriter papper = new StringWriter();
            PrintWriter penna = new PrintWriter(papper);
            databaseFailure.printStackTrace(penna);
            String  stachTraceString = papper.toString();
            logger.log("DatabasFel " + databaseFailure.getMessage() +" \n" + stachTraceString);
            throw new ItemScanFailureException(itemID);

        }

      //ItemDTO itemDTO = inventorySystem.getItem(itemID, itemAmount);
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


