package se.kth.iv1350.sellProcess.model;

public class DiscountPercentPriceBased {
    public double getDiscount(double totalPrice) {
        if (totalPrice >= 500) {
            return totalPrice * 0.05;
        }
        return 0;
    }
}