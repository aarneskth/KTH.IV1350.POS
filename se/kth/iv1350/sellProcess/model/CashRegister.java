package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

public class CashRegister {
    private PayedAmount payment;



    public CashRegister(){

    }

    public void addPayment(PayedAmount payment){
        this.payment = payment;
    }

    public Change calcylateChange(SaleDTO saleInfo){
        Change change = new Change(payment, saleInfo);
        change.calculateChange();
        return change;
        }
    }
