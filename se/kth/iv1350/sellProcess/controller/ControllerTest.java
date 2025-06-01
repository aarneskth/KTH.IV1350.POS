package se.kth.iv1350.sellProcess.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.sellProcess.integration.*;

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
        assertThrows (InvalidInputException.class, () ->{
            controller.scanItem("OST123", -1);
        });
    }

        @Test
    void testInvalidItemInputExceptionZero()  {
        assertThrows (InvalidInputException.class, () ->{
            controller.scanItem("OST123",  0);
        });
    }


    @Test
    void testInvalidItemInputExceptionNoID()  {
        assertThrows (InvalidInputException.class, () ->{
            controller.scanItem("OSTi", 1);
        });
    }

}
