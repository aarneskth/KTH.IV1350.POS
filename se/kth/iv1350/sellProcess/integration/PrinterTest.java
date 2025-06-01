package se.kth.iv1350.sellProcess.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sellProcess.model.PayedAmount;
import se.kth.iv1350.sellProcess.model.Receipt;
import se.kth.iv1350.sellProcess.model.Sale;

public class PrinterTest {

    private Printer printer;
    private Receipt receipt;
    private Sale sale;
    private PayedAmount payedAmount;

    @BeforeEach
    void setUp() {
        printer = new Printer();
        sale = new Sale();
        receipt = new Receipt(sale.getSaleInfo());
        payedAmount = new PayedAmount(100);
    }

    @AfterEach
    void tearDown() {
        sale = null;
        printer = null;
        receipt = null;
        payedAmount = null;
    }

    @Test
    void testPrintReceipt() {

        printer.printReceipt(receipt, payedAmount);

    }
}
