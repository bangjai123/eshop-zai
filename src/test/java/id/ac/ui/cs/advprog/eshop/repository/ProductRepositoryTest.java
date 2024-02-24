package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void testCreateAndFInd(){
        Product product = new Product();
        product.setItemId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product.setItemName("Sampo cap Bambang");
        product.setItemQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getItemId(),savedProduct.getItemId());
        assertEquals(product.getItemName(),savedProduct.getItemName());
        assertEquals(product.getItemQuantity(),savedProduct.getItemQuantity());
    }

    @Test
    void testFindallIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setItemId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setItemName("Sampo Cap Bambang");
        product1.setItemQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setItemId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setItemName("Sampo Cap Usep");
        product2.setItemQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getItemId(),savedProduct.getItemId());
        savedProduct = productIterator.next();
        assertEquals(product2.getItemId(),savedProduct.getItemId());
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testDeleteFunction(){
        Product product1 = new Product();
        product1.setItemId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setItemName("Sampo Cap Bambang");
        product1.setItemQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setItemId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setItemName("Sampo Cap Usep");
        product2.setItemQuantity(50);
        productRepository.create(product2);

        productRepository.delete("eb55e9f-1c39-460e-8860-71af6af63bd6");
        productRepository.delete("a0f9de46-90b1-437d-a0bf-d0821dde9096");

        List<Product> arrayListProduct = productRepository.getItemData();
        assertTrue(arrayListProduct.isEmpty());

    }

    @Test
    void testDeleteOnlyOne(){
        Product product1 = new Product();
        product1.setItemId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setItemName("Sampo Cap Bambang");
        product1.setItemQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setItemId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setItemName("Sampo Cap Usep");
        product2.setItemQuantity(50);
        productRepository.create(product2);

        productRepository.delete("eb55e9f-1c39-460e-8860-71af6af63bd6");

        List<Product> arrayListProduct = productRepository.getItemData();
        assertFalse(arrayListProduct.isEmpty());
        Product productTersisa = productRepository.findById("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        assertTrue(arrayListProduct.contains(productTersisa));
    }

    @Test
    void testEditProductTunggal(){
        Product product1 = new Product();
        product1.setItemId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setItemName("Sampo Cap Bambang");
        product1.setItemQuantity(100);
        productRepository.create(product1);

        Product productYangDiinginkan = new Product();
        productYangDiinginkan.setItemName("Sampo Cap Badak");
        productYangDiinginkan.setItemQuantity(19);
        productRepository.update("eb55e9f-1c39-460e-8860-71af6af63bd6",productYangDiinginkan);

        List<Product> arrayListProduct = productRepository.getItemData();
        assertEquals(productYangDiinginkan.getItemName(),arrayListProduct.getFirst().getItemName());
        assertEquals(productYangDiinginkan.getItemQuantity(),arrayListProduct.getFirst().getItemQuantity());

    }
    @Test
    void testEditProductSalahSatu(){
        Product product1 = new Product();
        product1.setItemId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setItemName("Sampo Cap Bambang");
        product1.setItemQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setItemId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setItemName("Sampo Cap Usep");
        product2.setItemQuantity(50);
        productRepository.create(product2);

        Product productYangDiinginkan = new Product();
        productYangDiinginkan.setItemName("Sampo Cap Badak");
        productYangDiinginkan.setItemQuantity(19);
        productRepository.update("eb55e9f-1c39-460e-8860-71af6af63bd6",productYangDiinginkan);

        List<Product> arrayListProduct = productRepository.getItemData();
        assertEquals(productYangDiinginkan.getItemName(),arrayListProduct.getFirst().getItemName());
        assertEquals(productYangDiinginkan.getItemQuantity(),arrayListProduct.getFirst().getItemQuantity());
        assertNotEquals(productYangDiinginkan.getItemName(),product2.getItemName());
        assertNotEquals(productYangDiinginkan.getItemQuantity(), product2.getItemQuantity());



    }
    @Test
    void testGenerateProductId(){
        Product product1 = new Product();
        productRepository.create(product1);
        assertNotEquals(product1.getItemId(),"");

    }
    @Test
    void testIfIdDoesNotExists(){
        Product product1 = new Product();
        productRepository.create(product1);
        assertNull(productRepository.findById("null"));
        assertNotNull(productRepository.findById(product1.getItemId()));
    }
}
