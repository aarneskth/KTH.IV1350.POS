package se.kth.iv1350.sellProcess.integration;

public class PayedAmount {
    private final double value;

    /*
     * creates a instance, represents the payed amount of the customer.
     * 
     * @param amount    represents the amount payed in cash for the goods to be bought.
     */

    public PayedAmount(double amount){
        this.value = amount;
    }

    public double getAmount(){

        return value;
    }



}
