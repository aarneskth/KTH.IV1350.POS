package se.kth.iv1350.sellProcess.integration;

import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.Item;
import se.kth.iv1350.sellProcess.model.Receipt;
import java.text.DecimalFormat;

public class Printer {

    private StringBuilder saleData;
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
        DecimalFormat df = new DecimalFormat("#.00");
        saleData = new StringBuilder();
        SaleDTO data = receipt.getReceipt();

        saleData.append("\n-------------------KVITTO--------------------\n");
        saleData.append(String.format("%-30s %14s\n", "", "SEK"));
        for (Item item : data.getAllItems()) {

        String name = item.getItemDTO().getItemName() + " " + item.getItemDTO().getItemInfo(); 
        int quantity = item.itemGetAmount();
        double unitPrice = item.getItemDTO().getItemPrice();
        double totalPrice = item.getPrice();

        String quantityPart = quantity > 1
            ? String.format("%d st * %s", quantity, df.format(unitPrice))
            : "";  // Visa inget om bara 1 st

        saleData.append(String.format("%-25s %-14s %6s\n",
                name,
                quantityPart,
                df.format(totalPrice)));
        }

        saleData.append("---------------------------------\n");
        saleData.append(String.format("%-40s %6s\n", "Moms:", df.format(data.getVAT())));
        saleData.append(String.format("%-40s -%6s\n", "Avdragen rabatt:", df.format(data.getDiscount())));
        saleData.append(String.format("%-40s %6s\n", "Att betala:", df.format(data.getTotalPrice())));
        saleData.append(String.format("%-40s %6s\n", "Kontant betalning:", df.format(payedAmount.getAmount())));

        double change = payedAmount.getAmount() - data.getTotalPrice();
        saleData.append(String.format("%-40s %6s\n", "Växel:", df.format(change)));
        saleData.append("---------------------------------------------\n");
        saleData.append("Välkommen åter!\n");
    }

    public String getKvitto(){
        return saleData.toString();
    }

}
