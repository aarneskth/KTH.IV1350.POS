package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.PriceBeforeDiscountDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

public interface DiscountInterface {
    double checkDiscount(SaleDTO itemList, boolean isMember, PriceBeforeDiscountDTO totalPrice);
}