package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentTest {
    private Order order;
    private Map<String,String> map = new HashMap<>();

    @BeforeEach
    void setUp(){
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4137-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        products.add(product1);
        products.add(product2);

        this.order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
            products, 1708560000L,"Safira Sudrajat");

        this.map.put("SomeString","AnotherString");
    }
    @Test
    void testCreatePaymentNullOrder(){
        this.order = null;


        assertThrows(IllegalArgumentException.class,() ->{
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
                "CashOnDelivery",this.map, this.order);
        });
    }

    @Test
    void testCreatePaymentSuccessStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
            "CashOnDelivery",this.map, this.order, "SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentRejectedStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
            "CashOnDelivery",this.map, this.order, "REJECTED");
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        assertThrows(IllegalArgumentException.class,()->{
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
                "CashOnDelivery",this.map, this.order, "AMPUN");
        });
    }

    @Test
    void testCreatePaymentMethodCashOnDelivery(){
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
            "CashOnDelivery",this.map, this.order);
        assertEquals("CashOnDelivery", payment.getMethod());
    }

    @Test
    void testCreatePaymentMethodVoucher(){
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
            "Voucher",this.map, this.order);
        assertEquals("Voucher", payment.getMethod());
    }

    @Test
    void testCreatePaymentMethodInvalid(){
        assertThrows(IllegalArgumentException.class,()->{
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
                "Utang",this.map, this.order);
        });
    }

    @Test
    void testSetToInvalidStatus(){
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb139d79b",
            "Voucher",this.map, this.order);
        assertThrows(IllegalArgumentException.class,()->payment.setStatus("Utang"))
    }
}
