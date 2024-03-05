package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.UUID;

@Repository
public class ProductRepository extends GeneralRepository<Product> {

    @Override
    public Product update(String productId, Product updatedItem){
        Product oldProduct = findById(productId);
        oldProduct.setItemName(updatedItem.getItemName());
        oldProduct.setItemQuantity(updatedItem.getItemQuantity());
        return updatedItem;
    }
}
