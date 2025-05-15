package se.kth.iv1350.sellProcess.view;

import se.kth.iv1350.sellProcess.controller.Controller;
import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.model.*;



public class view {

    private Controller controller;

    public view(Controller controller) {
        this.controller = controller;
    }

    public void startSale()  {

        controller.startSale();

        String itemsToBuy[][] = {
            {"HON123", "1.5"},
            {"FEL123", "1"},
            {"APP123", "0"},            
            {"APP123", "2"},
            {"KOTT123", "1"}};

            for (String [] string: itemsToBuy){
                String stringID;
                int amount = 0;

        try{

            stringID = string[0];
            amount = Integer.parseInt(string[1]);

        Item item = controller.scanItem(stringID,amount);

        } catch (ItemCantBeRegException e){
            System.out.println (e.getMessage());
            
        }catch(NumberFormatException ee){
            System.out.println ();
        }

        //controller.scanItem("HON123", 1);
        /*scanAndPrint("GLASS123", 2);
        scanAndPrint("MJÖLK123", 1);
        scanAndPrint("FEL_ID", 1); */

    }
    PayedAmount paidAmount = new PayedAmount(100);
    controller.pay(paidAmount);

    System.out.println(controller.getKvitto());
     System.out.println("Sale has ended");
    
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

