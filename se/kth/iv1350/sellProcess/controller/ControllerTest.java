package se.kth.iv1350.sellProcess.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.*;

public class ControllerTest {

    private Controller controller;

    @BeforeEach
    void setUp() {
        Printer printer = new Printer();
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        ExternalAccountingSystem invExternalAccountingSystem = new ExternalAccountingSystem();
        controller = new Controller(printer, inventorySystem, invExternalAccountingSystem);
        controller.startSale();
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void testCheckDiscount() {
        controller.checkDiscount(null, true);

    }

    @Test
    void testCheckMembershipStatus() {

        boolean result = controller.checkMembershipStatus("Petrus", 1225);
        assertTrue(result, "Förväntar att medlemsstatus alltid returnerar true.");
    }

    @Test
    void testEndsale() {

        controller.endsale();
        controller.scanItem("1", 1);

        // "Förvantas skriva ut ingen försäljning"

    }

    @Test
    void testPay() {

        controller.scanItem("1", 1);
        PayedAmount amount = new PayedAmount(100);
        controller.pay(amount); // NO crash
    }

    @Test
    void testScanItem() {
        controller.scanItem("1", 1);
        controller.scanItem("1", 1);

    }

    @Test
    void testStartSale() {
        controller.startSale();
        controller.scanItem("1", 1);
        // If notthing crash is working.

    }
}
