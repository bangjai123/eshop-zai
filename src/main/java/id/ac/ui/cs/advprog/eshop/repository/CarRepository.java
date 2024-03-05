package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository extends GeneralRepository<Car>{
    @Override
    public Car update(String id, Car updatedItem){
        for(int i = 0; i < itemData.size(); i++){
            Car car = (Car) itemData.get(i);
            if(car.getItemId().equals(id)){
                car.setItemName(updatedItem.getItemName());
                car.setCarColor(updatedItem.getCarColor());
                car.setItemQuantity(updatedItem.getItemQuantity());
                return car;
            }
        }
        return null;
    }
}
