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
        product.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(),savedProduct.getProductId());
        assertEquals(product.getProductName(),savedProduct.getProductName());
        assertEquals(product.getProductQuantity(),savedProduct.getProductQuantity());
    }

    @Test
    void testFindallIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(),savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(),savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testDeleteFunction(){
        Product product1 = new Product();
        product1.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        productRepository.delete("eb55e9f-1c39-460e-8860-71af6af63bd6");
        productRepository.delete("a0f9de46-90b1-437d-a0bf-d0821dde9096");

        List<Product> arrayListProduct = productRepository.getProductData();
        assertTrue(arrayListProduct.isEmpty());

    }

    @Test
    void testDeleteOnlyOne(){
        Product product1 = new Product();
        product1.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        productRepository.delete("eb55e9f-1c39-460e-8860-71af6af63bd6");

        List<Product> arrayListProduct = productRepository.getProductData();
        assertFalse(arrayListProduct.isEmpty());
        Product productTersisa = productRepository.findProductById("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        assertTrue(arrayListProduct.contains(productTersisa));
    }

    @Test
    void testEditProductTunggal(){
        Product product1 = new Product();
        product1.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product productYangDiinginkan = new Product();
        productYangDiinginkan.setProductName("Sampo Cap Badak");
        productYangDiinginkan.setProductQuantity(19);
        productRepository.editProduct("eb55e9f-1c39-460e-8860-71af6af63bd6",productYangDiinginkan);

        List<Product> arrayListProduct = productRepository.getProductData();
        assertEquals(productYangDiinginkan.getProductName(),arrayListProduct.getFirst().getProductName());
        assertEquals(productYangDiinginkan.getProductQuantity(),arrayListProduct.getFirst().getProductQuantity());

    }
    @Test
    void testEditProductSalahSatu(){
        Product product1 = new Product();
        product1.setProductId("eb55e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product productYangDiinginkan = new Product();
        productYangDiinginkan.setProductName("Sampo Cap Badak");
        productYangDiinginkan.setProductQuantity(19);
        productRepository.editProduct("eb55e9f-1c39-460e-8860-71af6af63bd6",productYangDiinginkan);

        List<Product> arrayListProduct = productRepository.getProductData();
        assertEquals(productYangDiinginkan.getProductName(),arrayListProduct.getFirst().getProductName());
        assertEquals(productYangDiinginkan.getProductQuantity(),arrayListProduct.getFirst().getProductQuantity());
        assertNotEquals(productYangDiinginkan.getProductName(),product2.getProductName());
        assertNotEquals(productYangDiinginkan.getProductQuantity(), product2.getProductQuantity());



    }
    @Test
    void testGenerateProductId(){
        Product product1 = new Product();
        productRepository.create(product1);
        assertNotEquals(product1.getProductId(),"");

    }
    @Test
    void testIfIdDoesNotExists(){
        Product product1 = new Product();
        productRepository.create(product1);
        assertNull(productRepository.findProductById("null"));
        assertNotNull(productRepository.findProductById(product1.getId()));
    }
}
