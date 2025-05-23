package se.kth.iv1350.sellProcess.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.sellProcess.integration.*;
import se.kth.iv1350.sellProcess.integration.DTO.SaleDTO;
import se.kth.iv1350.sellProcess.model.*;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    private Controller controller;
    private ExternalInventorySystem inventorySystem;
    @BeforeEach
    void setUp() {
        Printer printer = new Printer();
        inventorySystem = ExternalInventorySystem.getExternalInventorySystem();
        ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
        controller = new Controller(printer, accountingSystem);
        controller.startSale();
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

           @Test
    void testItemScanFailureException()  {
        assertThrows (ItemScanFailureException.class, () ->{
            controller.scanItem("DataBasFel123", 1);
        });
    }

        @Test
    void testInvalidItemInputExceptionMinusOne()  {
        assertThrows (InvalidItemInputException.class, () ->{
            controller.scanItem("OST123", -1);
        });
    }

        @Test
    void testInvalidItemInputExceptionZero()  {
        assertThrows (InvalidItemInputException.class, () ->{
            controller.scanItem("OST123",  0);
        });
    }


    @Test
    void testInvalidItemInputExceptionNoID()  {
        assertThrows (InvalidItemInputException.class, () ->{
            controller.scanItem("OSTi", 1);
        });
    }

}
