package se.kth.iv1350.sellProcess.view;

public class TotalRevenueView implements SaleObserver{

    private double total;
    @Override
    public void sumUpSale(double totalSalePrice) {
        total += totalSalePrice;

        System.out.println("Dagens totala försäljning uppgår till: " + total + " kr.");
    }

}
