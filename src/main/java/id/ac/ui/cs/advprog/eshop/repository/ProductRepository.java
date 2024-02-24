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
        if(product.getId().equals("")){
            product.setId(UUID.randomUUID().toString());
        }
        productData.add(product);
        return product;
    }
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public void delete(String productId) {
        productData.removeIf(product -> product.getId().equals(productId));
    }

    public void editProduct(String productId, Product editedProduct){
        Product oldProduct = findProductById(productId);
        oldProduct.setName(editedProduct.getName());
        oldProduct.setQuantity(editedProduct.getQuantity());
    }
    public Product findProductById(String productId){
        for(int i=0;i<productData.size();i++){
            if(productData.get(i).getId().equals(productId)){
                return productData.get(i);
            }
        }
        return null;
    }
}
