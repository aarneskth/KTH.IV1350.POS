package se.kth.iv1350.sellProcess.view;

import se.kth.iv1350.sellProcess.integration.SaleLogger;

public class TotalRevenueFileOutput implements SaleObserver {
private final SaleLogger logger = new SaleLogger();

private  double total;
        
    @Override
    public void sumUpSale(double totalSalePrice) {
        total += totalSalePrice;
        logger.log("Total intäkt: " + String.format("%.2f", total));
    }

}
