package se.kth.iv1350.sellProcess.model;
import se.kth.iv1350.sellProcess.integration.DTO.*;;

public class Receipt {

    private SaleDTO saleinfo;

    /*
     * creates a new instance, Represents the receipt you get as a proof of the payment. 
     * 
     * @param saleinfo          representing the information of the sale including the list of items, total price etc.
     */
    public Receipt(SaleDTO saleInfo){

        this.saleinfo = saleInfo;
    }

    public SaleDTO getReceipt(){

        return this.saleinfo;
    }

}
