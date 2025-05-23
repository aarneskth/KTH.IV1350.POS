package se.kth.iv1350.sellProcess.model;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.integration.DiscountRegister;
public class Discount {

    private  String itemID;
    private  double percentage;
    private  double fixedDiscount;
    private  double req;
    private DiscountRegister register;

    /*
     * Creates a new instance, represents the discount of the price in percentage and/or amount based.
     * 
     * 
     */

    public Discount(){
        this.register = new DiscountRegister();  
    }

    /*
     * checkDiscount            Checks if the customer is eligible for discounts stored in the discount register.  
     * 
     * @param   saleinfo         representing the information of the sale including the list of items, total price etc.
     *          membershipStatus contains a boolean value that tells if the customer is a member or not.
     * 
     * @return                   return the value of the discount tha the customer is eligible for. 
     */

    public double checkDiscount(SaleDTO saleInfo, boolean membershipStatus){
        
        return register.checkDiscount(saleInfo, membershipStatus);
    }

}
