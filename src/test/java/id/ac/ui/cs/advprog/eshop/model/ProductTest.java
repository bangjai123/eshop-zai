package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ProductTest {
    Product product;

    @BeforeEach
    void setUp(){
        this.product = new Product();
        this.product.setItemId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        this.product.setItemName("Sampo Cap Bambang");
        this.product.setItemQuantity(100);
    }
    @Test
    void testGetItemId(){
        assertEquals("eb55e9f-1c39-460e-8860-71af6af63bd6", this.product.getItemId());
    }

    @Test
    void testGetItemName(){
        assertEquals("Sampo Cap Bambang", this.product.getItemName());
    }

    @Test
    void testGetItemQuantity(){
        assertEquals(100, this.product.getItemQuantity());
    }
}
