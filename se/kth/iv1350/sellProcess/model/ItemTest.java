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
        itemDTO = new ItemDTO("MILK", 200, 0.55, "MILK123");
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
        assertEquals(200.0, item.getPrice(), 0.0001);
    }

    @Test
    void testGetVatRate() {
        assertEquals(0.55, item.getVatRate(), 0.0001);
    }

    @Test
    void testItemGetAmount() {
        assertEquals(2, item.itemGetAmount());
    }
}
