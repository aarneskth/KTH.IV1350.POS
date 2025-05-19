package se.kth.iv1350.sellProcess.view;

import se.kth.iv1350.sellProcess.controller.Controller;
import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.*;



public class View {

    private Controller controller;
  //private final FileLogger logger = new FileLogger();
    public View(Controller controller) {
        this.controller = controller;
        TotalRevenueView totalRevenueView = new TotalRevenueView();
        controller.addSaleObserver(totalRevenueView);
    }

    public void startSale()  {

        controller.startSale();

        TotalRevenueView totalRevenueView = new TotalRevenueView();
        TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
        controller.addSaleObserver(totalRevenueView);
        controller.addSaleObserver(totalRevenueFileOutput);
        
        String itemsToBuy[][] = {
            {"HON123", "1.5"},
            {"HON123", "1"},
            {"FEL123", "1"},
            {"APP123", "0"},            
            {"APP123", "2"},
            {"OST123", "1"},
            {"SPA123", "1"},
            {"DataBasFel123","1"}};

            for (String [] string: itemsToBuy){
                String stringID;
                int amount = 0;

        try{

            stringID = string[0];
            amount = Integer.parseInt(string[1]);

        Item item = controller.scanItem(stringID,amount);

        } catch (InvalidItemInputException invalidScan){
            System.out.println (invalidScan.getMessage());
            
        }catch(NumberFormatException nonInt){

            System.out.println("Icke heltal angett. Varan ej registrerad. Vänlig korrigera.");

        }catch(ItemScanFailureException itemscan){

            itemscan.getMessage();
        }
        
        
        /* catch(DatabaseFailureException eee){
             System.out.println("Kunde inte komma åt databasen, varan ej registrerad!");
             
        }*/

    }

    boolean isMember = controller.checkMembershipStatus("Björn", "ID123");
    controller.checkDiscount(isMember);
    SaleDTO saleInfo = controller.getSaleInfo();

    PayedAmount paidAmount = new PayedAmount(200);
    controller.pay(paidAmount);

    controller.addSaleObserver(totalRevenueView);
    System.out.println(controller.getKvitto());
  
    System.out.println("Försäljningen avslutad.");
    
        controller.endsale();
    }
}

