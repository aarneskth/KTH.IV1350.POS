
package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.DiscountRulesDTO;

public class DiscountFactory {
    public static DiscountInterface getDiscount(DiscountFactoryEnum type, DiscountRulesDTO rule) {
    return switch(type) {
        case MEMBER_DISCOUNT -> new DiscountPercentMembershipBased(rule);
        case TOTAL_PRICE_DISCOUNT -> new DiscountPercentPriceBased(rule);
        case ITEM_DISCOUNT -> new DiscountFixedItemBased(rule);
        default -> new DiscountNone();
        };
    }
}

