package se.kth.iv1350.sellProcess.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.integration.DTO.*;
import se.kth.iv1350.sellProcess.model.*;
import se.kth.iv1350.sellProcess.view.SaleObserver;


public class Controller {
    private Printer printer;
    private CustomerMembershipRegister membershipRegister;
    private ItemDTO itemDTO;
    private static final FileLogger logger = new FileLogger();
    private static final ExternalInventorySystem externalInventorySystem = ExternalInventorySystem.getExternalInventorySystem();
    private final DiscountRegister discountReg; 


    Sale sale = new Sale();
    private ExternalAccountingSystem accountingSystem;

    /*
     * creates a new instance representing the construktor of the Controller
     * 
     * @param printer           takes an object of the printer for printing the receipt
     * @param accountingSystem  takes an object of the ExternalAccountingSystem to store the
     *                          economical related information about every sale. Not yet implemented.
     * 
     * 
     */

    public Controller(Printer printer, ExternalAccountingSystem accountingSystem) {

        this.printer = printer;
        this.accountingSystem = accountingSystem;
        this.membershipRegister = new CustomerMembershipRegister();
        this.discountReg = new DiscountRegister(); 
    }

    /*
    * startSale         creates an object of Sale
    * 
    */

    public void startSale() {

        this.sale = new Sale();
    }

    /*
     * scanItem         Register every item to be scanned for buying including the amount of 
     *                  the item.
     * 
     * @param itemID        Representing the barcode on the item for scanning the item.
     * @param itemAmount    The amount of the specific item to be scanned.
     * 
     * 
     * @throws InvalidItemInputException    Throws an exception if the itemID is not found, or if 
     *                                      the item amount is typed wrongly like 0 or -1.    
     * @throws ItemScanFailureException     Throws an exception if the inventory database is 
     *                                      not found.
     * 
     */

    public Item scanItem(String itemID, int itemAmount) throws ItemScanFailureException, InvalidInputException{

        try {
            this.itemDTO = externalInventorySystem.getItem(itemID, itemAmount);

        } catch (InvalidInputException regException) {
            throw new InvalidInputException(regException.getReason(),regException.getObjects());

        } catch(DatabaseFailureException databaseFailure){

            StringWriter papper = new StringWriter();
            PrintWriter penna = new PrintWriter(papper);
            databaseFailure.printStackTrace(penna);
            String  stachTraceString = papper.toString();
            logger.log("DatabasFel " + databaseFailure.getMessage() +" \n" + stachTraceString);
            throw new ItemScanFailureException(itemID);

        }
        return sale.scanitem(itemDTO, itemAmount);
    }

    /*
     * pay                  Representing the process of paying for the entire sale.
     * 
     * @param payedAmount   The amount to be payed.
     * 
     */

    public void pay(PayedAmount payedAmount) {

        sale.printReceipt(printer, payedAmount);
    }

    /*
     * checkDiscount            Representing the process of paying for the entire sale.
     * 
     * @param membershipStatus  takes in a boolean of true or false, true if the customer 
     *                          is a member, false if not.                        
     * 
     */

    public void checkDiscount(boolean membershipStatus) {
    SaleDTO itemList = sale.getSaleInfo();
    PriceBeforeDiscountDTO totalPrice = sale.createPriceBeforeDisocuntDTO();

    Discount discount = new Discount(totalPrice, membershipStatus, itemList, discountReg);
    double totalDiscount = discount.calculateTotalDiscount();
    sale.setDiscount(totalDiscount);
    sale.calculateTotalPriceWithVAT();
}

     /*
     * checkMembershipStatus    represent the check process if the costumer is a member
     * 
     * @param customerName      Takes in the name of the customer as a String. 
     * @param customerID        Takes in the ID of the customer as a String.
     */

    public boolean checkMembershipStatus(String customerName, String customerID) {

        return membershipRegister.checkMembershipStatus(customerName, customerID);
    }

    public SaleDTO getSaleInfo() {
        return sale.getSaleInfo();
    }

    public String getReceipt(){

        return printer.getReceipt();
    }

    public void addSaleObserver(SaleObserver obs){
        sale.addObserver(obs);
    }

        public void endsale() {

    }
}


