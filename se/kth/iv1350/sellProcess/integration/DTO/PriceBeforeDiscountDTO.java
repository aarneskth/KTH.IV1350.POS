package se.kth.iv1350.sellProcess.integration.DTO;

/**
 * The DTO contains the price before the discount is applied.
 */

public class PriceBeforeDiscountDTO {

    private double priceBeforeDiscount = 0;
    private double vat;

    /**
     * creates a new instance wich holds the total price before the discount and VAT is applied.
     * @param priceBeforeDiscount       Stands for the price of all items before the discount or
     *                                  VAT has been applied.              
     * @param vat                       The VAT amount on the price.
     */

    public PriceBeforeDiscountDTO(double priceBeforeDiscount, double vat){
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.vat = vat;
    }

    public double getTotalBeforeDiscount(){
        return priceBeforeDiscount;
    }

    public double getVAT() {
        return vat;
    }

}
