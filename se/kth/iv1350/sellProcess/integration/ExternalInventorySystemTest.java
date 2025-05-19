package se.kth.iv1350.sellProcess.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sellProcess.model.Sale;

public class ExternalInventorySystemTest {
private ExternalInventorySystem inventorySystem;
        @BeforeEach
    void setUp() {
       inventorySystem = ExternalInventorySystem.getExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
       
    }

    @Test
    void testGetItem() {
        try {
            inventorySystem.getItem("OST123", 1);
        } catch ( e) {
            // TODO: handle exception
        }
    }

    @Test
    void testUpdateInventory() {

    }
}
