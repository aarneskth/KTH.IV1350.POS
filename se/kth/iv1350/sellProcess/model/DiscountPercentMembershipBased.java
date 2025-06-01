package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.DiscountRulesDTO;
import se.kth.iv1350.sellProcess.integration.DTO.PriceBeforeDiscountDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

public class DiscountPercentMembershipBased implements DiscountInterface {
    private final DiscountRulesDTO rule;

    public DiscountPercentMembershipBased(DiscountRulesDTO rule){
        this.rule = rule;
    }

    @Override
    public double checkDiscount(SaleDTO itemList, boolean isMember, PriceBeforeDiscountDTO totalPrice) {
        if (!isMember) {
            return 0;
        }

        double priceExclVAT = totalPrice.getTotalBeforeDiscount() - totalPrice.getVAT();
        return priceExclVAT * rule.getDiscountPercentage();
    }
}
