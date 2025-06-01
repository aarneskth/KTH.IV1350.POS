package se.kth.iv1350.sellProcess.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;

import static org.junit.jupiter.api.Assertions.*;

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
    void testCalculateTotalVAT() {
        sale.scanitem(new ItemDTO("Sparris", 20, 0.12, "SPA123", "gul"), 1);
        double vat = sale.calculateTotalVAT();
        assertTrue(vat > 0, "Moms bör vara större än 0 efter en vara skannats.");
    }

    @Test
    void testCalculateTotalPriceWithVat() {
        sale.scanitem(new ItemDTO("Sparris", 20, 0.12, "SPA123", "gul"), 1);
        sale.scanitem(new ItemDTO("Ost", 30, 0.12, "OST123", "blåmögel"), 1);
        sale.calculateTotalVAT();
        double total = sale.calculateTotalPriceWithVAT();
        assertEquals(56, total);
    }

    @Test
    void testGetSaleInfo() {
        sale.scanitem(new ItemDTO("Sparris", 20, 0.12, "SPA123", "grön"), 1);
        SaleDTO info = sale.getSaleInfo();
        assertNotNull(info);
        assertNotEquals(1, info.getAllItems());
        assertEquals("Sparris", info.getAllItems().get(0).getName());

    }

    @Test
    void testScanitem() {

        sale.scanitem(new ItemDTO("Sparris", 20, 0.12, "SPA123", "gul"), 1);
        sale.scanitem(new ItemDTO("Ost", 30, 0.12, "OST123", "blåmögel"), 2);
        sale.scanitem(new ItemDTO("Bröd", 30, 0.12, "BRO123", "Leksands"), 3);
        SaleDTO info = sale.getSaleInfo();
        int counter = 0;
        for (int i = 0; i < info.getAllItems().size(); i++) {
            counter += info.getAllItems().get(i).getItemAmount();
            
        }
        assertEquals(6, counter);
    }
}
