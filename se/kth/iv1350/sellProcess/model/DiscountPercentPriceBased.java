package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.DiscountRulesDTO;
import se.kth.iv1350.sellProcess.integration.DTO.PriceBeforeDiscountDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

public class DiscountPercentPriceBased implements DiscountInterface {

    private final DiscountRulesDTO rule;

    public DiscountPercentPriceBased(DiscountRulesDTO rule){
        this.rule = rule;
    }

    @Override
    public double checkDiscount(SaleDTO itemList, boolean isMember, PriceBeforeDiscountDTO totalPrice) {
        double price = itemList.getTotalPriceBeforeDiscount();
        if (price >= rule.getBigBuyDiscount()) {
            return price * rule.getDiscountPercentage();
        }
        return 0;
    }
}
