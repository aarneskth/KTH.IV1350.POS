package se.kth.iv1350.sellProcess.view;

import se.kth.iv1350.sellProcess.controller.Controller;
import se.kth.iv1350.sellProcess.integration.PayedAmount;
import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;

public class view {

    private Controller controller;

    public view(Controller controller) {
        this.controller = controller;
    }

    public void startSale() {
        controller.startSale();

        scanAndPrint("GLASS123", 2);
        scanAndPrint("MJÖLK123", 1);
        scanAndPrint("FEL_ID", 1); 

        PayedAmount paidAmount = new PayedAmount(100);
        controller.pay(paidAmount);

        controller.endsale();
    }

    private void scanAndPrint(String itemID, int amount) {
        ItemDTO item = controller.scanItem(itemID, amount);

        if (item == null) {
            System.out.println("Varning: Varan med ID '" + itemID + "' hittades inte.");
        } else {
            System.out.println("Skannad vara: " + item.getItemName() + 
                               ", Pris: " + item.getPrice() + 
                               ", Moms: " + (item.getItemVatRate() * 100) + " %");
        }
    }
}

