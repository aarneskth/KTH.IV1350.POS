package se.kth.iv1350.sellProcess.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import se.kth.iv1350.sellProcess.integration.DTO.ItemDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    private ItemDTO itemDTO;
    private Item item;

    @BeforeEach
    void setUp() {
        itemDTO = new ItemDTO("MILK", 20, 0.12, "MILK123");
        item = new Item(itemDTO, 2);
    }

    @AfterEach
    void tearDown() {
        itemDTO = null;
        item = null;
    }

    @Test
    void testGetItemDTO() {
        assertEquals(itemDTO, item.getItemDTO());
    }

    @Test
    void testGetItemID() {
        assertEquals("MILK123", item.getItemID());
    }

    @Test
    void testGetName() {
        assertEquals("MILK", item.getName());
    }

    @Test
    void testGetPrice() {
        assertEquals(40.0, item.getPrice());
    }

    @Test
    void testGetVatRate() {
        assertEquals(0.12, item.getVatRate());
    }

    @Test
    void testItemGetAmount() {
        assertEquals(2, item.itemGetAmount());
    }
}
