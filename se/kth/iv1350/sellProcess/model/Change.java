package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.integration.PayedAmount;

public class Change {

    private PayedAmount amount;
    private double change;
    private SaleDTO saleDTO;

    public Change(PayedAmount amount,SaleDTO saleDTO) {
        this.amount = amount;
        this.saleDTO = saleDTO;

    }

    public void calculateChange(){

        change =  saleDTO.getTotalPrice() - amount.getAmount();
    }


    public double getChange(){

        return change;
    }
}

