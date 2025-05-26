package se.kth.iv1350.sellProcess.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.sellProcess.integration.DTO.CustomerDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.DiscountOLD;

public class DiscountRegister {

    private final double memberDiscountRate = 0.10;
    private final double percentToBeReduced;
    private final double sumToBeReduced;
    private List<DiscountOLD> discounts = new ArrayList<>();

    /*
     *   
     * Creates a instance of the database that contains all the discount information
     *            
     */

    
    public DiscountRegister(){
        percentToBeReduced = 0;
        sumToBeReduced = 0;

    }

    /*
     *   check<Discount Checks if the the customer is entitled to a discount based on the total price of all goods, the kind of goods
     *                  and weither the customer is a member or not. The types of discounts that could be returned are percentual or
     *                  amount based. The method har so far only a check function for the memebership status due to lack of info in the
     *                  instructions.
     * 
     *  @param saleInfo             The sale info includes the total price of all goods to be bought and the list of all items, both 
     *                              relevant for checking if the customer could be entitled to discount.
     * 
     *         membershipStatus     Represents the membership status that gives access to certain disocunts.
     *       
     * @return                      The method when fully built, will return the discount as a amount calculated from the percentage 
     *                              and the sum to be reduced from the total price. So far only the membership status is controlled and
     *                              if the customer is a member he or she gets a discount of 10 %.          
     * 
     */


    public double checkDiscount(SaleDTO saleInfo, boolean membershipStatus){
        if(membershipStatus){
            double priceNOVAT = saleInfo.getTotalPrice() - saleInfo.getVAT();
            return priceNOVAT * memberDiscountRate;
        }
        return 0;
    }

}
