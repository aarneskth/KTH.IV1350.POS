package se.kth.iv1350.sellProcess.integration;

import java.text.DecimalFormat;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.Change;
import se.kth.iv1350.sellProcess.model.Item;
import se.kth.iv1350.sellProcess.model.PayedAmount;
import se.kth.iv1350.sellProcess.model.Receipt;

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
     * @param receipt           Represents the receipt you get as a proof of the payment.
     * @param payedAmount       Represents the amount payed by the customer.
     */

    public void printReceipt(Receipt receipt, PayedAmount payedAmount) {
        DecimalFormat df = new DecimalFormat("#.00");
      
        saleData = new StringBuilder();
        SaleDTO data = receipt.getReceipt();
        Change changeAmount = new Change(payedAmount, data);

        saleData.append("\n----------------------KVITTO------------------------\n");
        saleData.append(String.format("%-43s %7s\n", "", "SEK"));
        for (Item item : data.getAllItems()) {

        String name = item.getItemDTO().getItemName() + " " + item.getItemDTO().getItemInfo(); 
        int quantity = item.getItemAmount();
        double unitPrice = item.getItemDTO().getItemPrice();
        double totalPrice = item.getPrice();

        String quantityPart = String.format("%d st * %s", quantity, df.format(unitPrice));
        saleData.append(String.format("%-25s %-18s %7s\n",
                name,
                quantityPart,
                df.format(totalPrice)));
        }

        saleData.append("--------------------------------------\n");
        saleData.append(String.format("%-44s %7s\n", "Total: ", df.format(data.getTotalPriceBeforeDiscount())));
        saleData.append("--------------------------------------\n");
        saleData.append(String.format("%-44s %7s\n", "Moms:", df.format(data.getVAT())));
        saleData.append(String.format("%-44s -%6s\n", "Avdragen rabatt:", df.format(data.getDiscount())));
        saleData.append(String.format("%-44s %7s\n", "Att betala:", df.format(data.getTotalPrice())));
        saleData.append(String.format("%-44s %7s\n", "Kontant betalning:", df.format(payedAmount.getAmount())));

        changeAmount.calculateChange();
        double change = changeAmount.getChange();
        saleData.append(String.format("%-44s %7s\n", "Växel:", df.format(change)));
        saleData.append("----------------------------------------------------\n");
        saleData.append("Välkommen åter!\n");
    }

    public String getReceipt()
    {
        return saleData.toString();
    }

}
