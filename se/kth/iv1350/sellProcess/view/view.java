package se.kth.iv1350.sellProcess.view;

import se.kth.iv1350.sellProcess.controller.Controller;
import se.kth.iv1350.sellProcess.integration.PayedAmount;

public class view {

    private Controller controller;

    public view(Controller conrt) {
        this.controller = conrt;
    }

    public void startSale() {

        controller.startSale();
        controller.scanItem("GLASS123", 2);
        controller.scanItem(("MJÖLK123"), 1);
        PayedAmount paidAmount = new PayedAmount(100);
        controller.pay(paidAmount);
        controller.endsale();
    }

}
