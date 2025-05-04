package se.kth.iv1350.sellProcess.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.integration.PayedAmount;
import se.kth.iv1350.sellProcess.integration.Printer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;

public class SaleTest {
    private Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale();
    }

    @AfterEach
    void tearDown() {
        sale = null;
    }

    @Test
    void testCalculateTotaVAT() {
        sale.scanitem("GLASS123", 1);
        double vat = sale.calculateTotaVAT();
        assertTrue(vat > 0, "Moms bör vara större än 0 efter en vara skannats.");
    }

    @Test
    void testCalculateTotalPriceWithVat() {
        sale.scanitem("GLASS123", 1);
        sale.scanitem("MJÖLK123", 1);
        sale.calculateTotaVAT();
        double total = sale.calculateTotalPriceWithVat();
        assertEquals(22.4, total, 0.01);
    }

    @Test
    void testGetSaleInfo() {
        sale.scanitem("MJÖLK123", 1);
        SaleDTO info = sale.getSaleInfo();
        assertNotNull(info);
        assertNotEquals(1, info.getAllItems());
        assertEquals("MJÖLK", info.getAllItems().get(0).getName());

    }

    /*
     * @Test
     * void testPrintReceipt() {
     * sale.scanitem("AVACADO123", 1);
     * PayedAmount amount = new PayedAmount(100);
     * assertEquals(100, amount.getAmount(), 0.001, "fel");
     * 
     * }
     */

    @Test
    void testScanitem() {

        sale.scanitem("GLASS123", 3);
        SaleDTO info = sale.getSaleInfo();
        assertEquals(3, info.getAllItems().get(0).itemGetAmount());
    }
}
