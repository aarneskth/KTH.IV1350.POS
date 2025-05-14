package se.kth.iv1350.sellProcess.view;

import se.kth.iv1350.sellProcess.controller.Controller;
import se.kth.iv1350.sellProcess.integration.PayedAmount;
import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;
import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.model.*;



public class view {

    private Controller controller;

    public view(Controller controller) {
        this.controller = controller;
    }

    public void startSale() throws IllegalAmountException {

        controller.startSale();

        String itemsToBuy[][] = {
            {"HON123", "1"},
            {"FEL123", "1"},
            {"APP123", "0"},            
            {"APP123", "2"},
            {"KOTT123", "1"}};

            for (String [] string: itemsToBuy){
                String stringID = string[0];
                int amount = Integer.parseInt(string[1]);

        try{

        Item item = controller.scanItem(stringID,amount);

        } catch (IllegalAmountException e){
            System.out.println (e.getMessage());
            
        }

        //controller.scanItem("HON123", 1);
        /*scanAndPrint("GLASS123", 2);
        scanAndPrint("MJÖLK123", 1);
        scanAndPrint("FEL_ID", 1); */

       


    }
    PayedAmount paidAmount = new PayedAmount(100);
    controller.pay(paidAmount);
        controller.endsale();
    /*private void scanAndPrint(String itemID, int amount) throws IllegalAmountException{
        Item item = controller.scanItem(itemID, amount);
            
        }

        if (item == null) {
            System.out.println("Varning: Varan med ID '" + itemID + "' hittades inte.");
        } else {
            System.out.println("Skannad vara: " + item.getName() + 
                               ", Pris: " + item.getPrice() + 
                               ", Moms: " + (item.getVatRate() * 100) + " %");
        }*/
    }
}

