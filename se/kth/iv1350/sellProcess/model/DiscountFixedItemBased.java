package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.DiscountRulesDTO;
import se.kth.iv1350.sellProcess.integration.DTO.PriceBeforeDiscountDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

public class DiscountFixedItemBased implements DiscountInterface{

    private final DiscountRulesDTO rule;

    public DiscountFixedItemBased (DiscountRulesDTO rule){
        this.rule = rule;
    }

    @Override
    public double checkDiscount(SaleDTO itemList, boolean isMember, PriceBeforeDiscountDTO totalPrice) {
        double discount = 0;
        for (Item item : itemList.getAllItems()) { 
            if (item.getItemID().equals(rule.getIdentitfier())) {
                discount += rule.getDiscountInCash() * item.getItemAmount();
            }
        }
        return discount;
    }
}
