package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.UUID;

@Repository
public class ProductRepository extends GeneralRepository<Product> {

    public void update(String productId, Product editedProduct){
        Product oldProduct = findById(productId);
        oldProduct.setItemName(editedProduct.getItemName());
        oldProduct.setItemQuantity(editedProduct.getItemQuantity());
    }
}
