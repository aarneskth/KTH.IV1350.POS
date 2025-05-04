package se.kth.iv1350.sellProcess.integration;

import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.Receipt;
import se.kth.iv1350.sellProcess.model.Item;

public class Printer {

    /*
     * Creates a new instance, representing the printing machine for the receipe.
     */

    public Printer() {

    }

    /*
     * printReceipt Print the information about what the customer have bought
     * including time of sale.
     * 
     * @param receipt Represents the receipt you get as a proof of the payment.
     */

    public void printReceipt(Receipt receipt, PayedAmount payedAmount) {

        SaleDTO data = receipt.getReceipt();

        System.out.println("\n------KVITTO-------");

        for (Item item : data.getAllItems()) {

            System.out.println(item);

        }

        System.out.println("---------------------------");
        System.out.println("Moms " + data.getVAT() + " kr");
        System.out.println("Totalpris: " + data.getTotalPrice() + " kr");
        System.out.println("Kontant betalning: " + payedAmount.getAmount() + " kr");
        System.out.println("---------------------------------------------");
        System.out.println("Välkommen åter!");
    }

}
