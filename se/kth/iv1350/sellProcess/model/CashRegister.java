package se.kth.iv1350.sellProcess.model;

import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

/**
 * Represents the cash register that handles payment during a sale.
 * It stores the paid amount and calculates the change to give back to the customer.
 */

public class CashRegister {
    private PayedAmount payment;

/**
 * Creates a new instance of the CashRegister
 */

    public CashRegister(){

    }

    /**
     * addPayment       Stores the amount payed by the customer.
     * @param payment   Represents the amount payed by the customer.
     */

    public void addPayment(PayedAmount payment){
        this.payment = payment;
    }

    /**
     * calculateChange      Calculates the change to be handed back to the costumer.
     * @param saleInfo      Includes the total price of the sale for calculating the change.
     * @return              Representing the amount to return to the customer.
     */

    public Change calcylateChange(SaleDTO saleInfo){
        Change change = new Change(payment, saleInfo);
        change.calculateChange();
        return change;
        }
    }
