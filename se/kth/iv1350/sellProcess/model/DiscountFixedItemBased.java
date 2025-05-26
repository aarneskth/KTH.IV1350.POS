package se.kth.iv1350.sellProcess.model;

import java.util.List;

public class DiscountFixedItemBased {
    private static final String SparrisID = "SPA123"; 

    public double getDiscount(List<Item> items) {
        double discount = 0;
        for (Item item : items) {
            if (item.getItemID().equals(SparrisID)) {
                discount += 10 * item.getItemAmount();
            }
        }
        return discount;
    }
}
