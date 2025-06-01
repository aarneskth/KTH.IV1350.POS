package se.kth.iv1350.sellProcess.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;
import se.kth.iv1350.sellProcess.model.Item;

public class ExternalInventorySystemTest {
private ExternalInventorySystem inventorySystem;

    private ItemDTO itemDTO;
    private Item item;

        @BeforeEach
    void setUp() {
       inventorySystem = ExternalInventorySystem.getExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
       itemDTO = null;
       item =null;
    }

    @Test
    void testGetItem() throws Exception {
        itemDTO = inventorySystem.getItem("OST123", 1);
        item = new Item(itemDTO, 1);
        assertNotNull(item, "Ska ej returnera null.");
        assertEquals("OST123", item.getItemID());
        assertEquals(1, item.getItemAmount());
    }

        @Test
    void testInvalidInputZero()  {
        assertThrows (InvalidInputException.class, () ->{
            inventorySystem.getItem("OST123", 0);
        });
    }

        @Test
    void testInvalidInputNegNr()  {
        assertThrows (InvalidInputException.class, () ->{
            inventorySystem.getItem("OST123", -1);
        });
    }

        @Test
    void testInvalidInputNoID()  {
        assertThrows (InvalidInputException.class, () ->{
            inventorySystem.getItem("FEL_ID", 1);
        });
    }

        @Test
    void testDatabaseFailure()  {
        assertThrows (DatabaseFailureException.class, () ->{
            inventorySystem.getItem("DataBasFel123", 1);
        });
    }
}
