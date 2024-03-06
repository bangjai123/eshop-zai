package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PaymentRepositoryTest {

    PaymentRepository paymentRepository;

    List<Payment> payments;

    @BeforeEach
    void setUp() {
        Map<String,String> contoh = new HashMap<>();
        contoh.put("SomeString","AnotherString");
        paymentRepository = new PaymentRepository();

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        payments = new ArrayList<Payment>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b", products,
                1708560000L, "Safira Sudrajat");
        Payment payment1 = new Payment("1", PaymentMethod.VOUCHER.getValue(), contoh,order1);
        payments.add(payment1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078", products,
                1708570000L, "Safira Sudrajat");
        Payment payment2 = new Payment("2",PaymentMethod.CASH_ON_DELIVERY.getValue(), contoh,order2);
        payments.add(payment2);
        Order order3 = new Order("e334ef40-9eff-4da8-9487-8ee697ecbf1e", products,
                1708570000L, "Bambang Sudrajat");
        Payment payment3 = new Payment("3",PaymentMethod.CASH_ON_DELIVERY.getValue(), contoh,order3);
        payments.add(payment3);

    }

    @Test
    void testSaveCreate() {

        Payment payment = payments.get(1);
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getOrder(), findResult.getOrder());
    }

    @Test
    void testSaveUpdate() {
        Payment payment = payments.get(1);
        paymentRepository.save(payment);
        Payment newPayment = new Payment(payment.getId(),payment.getMethod(), payment.getMap(), payment.getOrder());
        Payment result = paymentRepository.save(newPayment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getOrder(), findResult.getOrder());
        assertEquals(PaymentStatus.SUCCESS.getValue(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdFound() {

        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMap(), findResult.getMap());
        assertEquals(payments.get(1).getOrder(), findResult.getOrder());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdNotFound(){
        for(Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("zczc");
        assertNull(findResult);
    }

    @Test
    void testgetAllPayments(){
        for(Payment payment : payments) {
            paymentRepository.save(payment);
        }
        assertEquals(paymentRepository.getAllPayments().size(),payments.size());
    }
}