package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
public interface GeneralService<T extends Product> {
    public T create(T item);
    public List<T> findAll();

    public void delete(String itemName);
    public void update(String itemId, T item);
    public T findById(String itemId);
}

