package se.kth.iv1350.sellProcess.startup;

import se.kth.iv1350.sellProcess.controller.Controller;
import se.kth.iv1350.sellProcess.integration.ExternalAccountingSystem;
import se.kth.iv1350.sellProcess.integration.Printer;
import se.kth.iv1350.sellProcess.view.view;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        //ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();

        Controller controller = new Controller(printer, accountingSystem);
        view v = new view(controller);

        v.startSale();
    }
}