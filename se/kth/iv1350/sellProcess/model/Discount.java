package se.kth.iv1350.sellProcess.model;

import java.util.List;

public class Discount {
    public double calculateDiscount(List<Item> items, double totalPrice, boolean isMember) {
        double totalDiscount = 0;

        DiscountPercentPriceBased disc1 = (DiscountPercentPriceBased) DiscountFactory.getDiscount("totalprisrabatt");
        totalDiscount += disc1.getDiscount(totalPrice);

        DiscountPercentMembershipBased disc2 = (DiscountPercentMembershipBased) DiscountFactory.getDiscount("medlemsrabatt");
        totalDiscount += disc2.getDiscount(totalPrice, isMember);

        DiscountFixedItemBased disc3 = (DiscountFixedItemBased) DiscountFactory.getDiscount("varurabatt")
        totalDiscount += disc3.getDiscount(items);


    }
}