package se.kth.iv1350.sellProcess.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.kth.iv1350.sellProcess.integration.DTO.DiscountRulesDTO;
import se.kth.iv1350.sellProcess.integration.DTO.PriceBeforeDiscountDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.DiscountFactory;
import se.kth.iv1350.sellProcess.model.DiscountFactoryEnum;
import se.kth.iv1350.sellProcess.model.DiscountInterface;

/**
 * DiscountRegister manages the available discount rules and provides
 * applicable discount strategies for a given sale. It holds a mapping between discount types 
 * and their corresponding rules and can return a list of discount strategies to be applied.
 */

public class DiscountRegister {

    private final Map<DiscountFactoryEnum, DiscountRulesDTO> register = new HashMap<>();
    
    /**
     * creates a new DiscounRegister instance, representing the discount rules for 
     * the three types of discounts.
     * 
     */

   public DiscountRegister(){

    register.put(DiscountFactoryEnum.ITEM_DISCOUNT,new DiscountRulesDTO("SPA123", 10, 0, DiscountFactoryEnum.ITEM_DISCOUNT,0));
    register.put(DiscountFactoryEnum.MEMBER_DISCOUNT,new DiscountRulesDTO("", 0, 0.10, DiscountFactoryEnum.MEMBER_DISCOUNT,0));
    register.put(DiscountFactoryEnum.TOTAL_PRICE_DISCOUNT,new DiscountRulesDTO("", 0, 0.05, DiscountFactoryEnum.TOTAL_PRICE_DISCOUNT,500)); 
   }

   /**
    * Returns the Discount rules for a specified discount.
    *
    * @param type           Stands for the type of the discount.
    * 
    */

    public DiscountRulesDTO getEnum(DiscountFactoryEnum type){

        return switch(type){

        case ITEM_DISCOUNT -> register.get(type);
        case MEMBER_DISCOUNT -> register.get(type);
        case TOTAL_PRICE_DISCOUNT -> register.get(type);
        };

    }

    /**
     * Returns a list of possible discount strategys for the sale.
     * 
     * @param itemList      The list of items as a SaleDTO that contains that information
     * @param isMember      A boolean expression y/n that tells if the customer is a member or not.
     * @param price         Contains of the price for all scanned items exkl. VAT and discounts.
     * @return              The method returns a list of possible discount strategys for the sale.
     */

    public List<DiscountInterface> getApplicableDiscounts(SaleDTO itemList, boolean isMember, PriceBeforeDiscountDTO price) {
    List<DiscountInterface> discounts = new ArrayList<>();

    for (DiscountFactoryEnum type : register.keySet()) {
        DiscountRulesDTO rule = register.get(type);
        DiscountInterface strategy = DiscountFactory.getDiscount(type, rule);
        discounts.add(strategy);
    }

    return discounts;
    }
}
