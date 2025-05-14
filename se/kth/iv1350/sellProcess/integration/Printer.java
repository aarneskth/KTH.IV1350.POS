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

        StringBuilder saleData = new StringBuilder();
        SaleDTO data = receipt.getReceipt();

        saleData.append("\n------KVITTO-------\n");

        for (Item item : data.getAllItems()) {

            System.out.println(item);

        }

        saleData.append("---------------------------\n");
        saleData.append("Moms " + data.getVAT() + " kr\n");
        saleData.append("Totalpris: " + data.getTotalPrice() + " kr\n");
        saleData.append("Kontant betalning: " + payedAmount.getAmount() + " kr\n");
        saleData.append("---------------------------------------------\n");
        saleData.append("Välkommen åter!\n");
    }

}
