package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public List<Product> getProductData(){
        return this.productData;
    }

    public Product create(Product product){
        if(product.getProductId().equals("")){
            product.setProductId(UUID.randomUUID().toString());
        }
        productData.add(product);
        return product;
    }
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public void delete(String productId) {
        productData.removeIf(product -> product.getProductId().equals(productId));
    }

    public void editProduct(String productId, Product editedProduct){
        Product oldProduct = findProductById(productId);
        oldProduct.setProductName(editedProduct.getProductName());
        oldProduct.setProductQuantity(editedProduct.getProductQuantity());
    }
    public Product findProductById(String productId){
        for(int i=0;i<productData.size();i++){
            if(productData.get(i).getProductId().equals(productId)){
                return productData.get(i);
            }
        }
        return null;
    }
}
