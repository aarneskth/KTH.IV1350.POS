package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.integration.PayedAmount;

public class Change {

    private PayedAmount amount;
    private SaleDTO saleInfo;
    private double change;

    /*
     * Konstruktorn tar betalat belopp och försäljningsinfon
     * för att beräkna växeln.
     * 
     * @param
     */

    public Change(PayedAmount amount, SaleDTO saleInfo) {
        this.amount = amount;
        this.saleInfo = saleInfo;       


    }

    public void calculateChange(){

        change = amount.getAmount() - saleInfo.getTotalPrice();
    }


    public double getChange(){

        return change;
    }
}

