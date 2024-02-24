package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
abstract class GeneralRepository<T extends Product>{
    List<T> itemData = new ArrayList<>();

    public T create(T item){
        if(item.getItemId()==null){
            UUID uuid = UUID.randomUUID();
            item.setItemId(uuid.toString());
        }
        itemData.add(item);
        return item;
    }
    public Iterator<T> findAll(){
        return itemData.iterator();
    }
    public T findById(String id){
        for(T item : itemData){
            if(item.getItemId().equals(id)){
                return item;
            }
        }
        return null;
    }
    public void delete(String id){
        itemData.removeIf(item -> item.getItemId().equals(id));
    }
    public List<T> getItemData(){
        return itemData;
    }

}
