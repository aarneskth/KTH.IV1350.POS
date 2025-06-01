package se.kth.iv1350.sellProcess.model;

import java.util.List;
import se.kth.iv1350.sellProcess.integration.DTO.PriceBeforeDiscountDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.integration.DiscountRegister;

public class Discount {

    private final PriceBeforeDiscountDTO priceBeforeDiscount; 
    private final boolean isMember;
    private final SaleDTO saleinfo;
    private final DiscountRegister discountReg;

        /**
     * Creates a new instance of {@code Discount} which calculates discounts based on
     * sale details, membership status, and available discount rules.
     *
     * @param priceBeforeDiscount The price and VAT before any discounts are applied.
     * @param isMember {@code true} if the customer is a member and eligible for membership discounts.
     * @param saleinfo The information about the sale, including items and quantities.
     * @param discountRegister The registry containing available discount rules and factories.
     */

    public Discount(PriceBeforeDiscountDTO priceBeforeDiscount, boolean isMember, SaleDTO saleinfo, DiscountRegister discountRegister){
    this.isMember = isMember;
    this.saleinfo = saleinfo;

    this.priceBeforeDiscount = priceBeforeDiscount;
    this.discountReg = discountRegister;

    }

    /**
     * calculateTotalDiscount       Calculates all the discounts of the sale by checking 
     *                              all the applicable discount rules in the discount register.
     * @return                      Returns the total discount as a double.
     */

    public double calculateTotalDiscount() {
        double totalDiscount = 0;
        List<DiscountInterface> discounts = discountReg.getApplicableDiscounts(saleinfo, isMember, priceBeforeDiscount);

        for (DiscountInterface discount : discounts) {
            totalDiscount += discount.checkDiscount(saleinfo, isMember, priceBeforeDiscount);
        }

        return totalDiscount;
    }

}





