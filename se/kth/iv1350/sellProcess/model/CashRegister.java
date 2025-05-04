package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.PayedAmount;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.Change;

public class CashRegister {



    public CashRegister(){

    }

    public void addPayment(PayedAmount payment){
        
    }

    public Change calcylateChange(SaleDTO saleInfo){
        Change change = new Change();
        return change;
        }
    }
