package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

public class Change {

    private PayedAmount amount;
    private SaleDTO saleInfo;
    private double change;

    /**
     * Creates a new instance of Change.
     * @param amount        The amount payed by the customer.
     * @param saleInfo      The sale information contains the cost of the sale to be payed.
     */

    public Change(PayedAmount amount, SaleDTO saleInfo) {
        this.amount = amount;
        this.saleInfo = saleInfo;       
    }

    /**
     * calculateChange      Calculates the change that the customer will get beack when paying.
     */

    public void calculateChange(){

        change = amount.getAmount() - saleInfo.getTotalPrice();
    }

    public double getChange(){
        return change;
    }
}

