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
    public Car update(String id, Car updatedProduct){
        for(int i = 0; i < productData.size(); i++){
            Car car = (Car) productData.get(i);
            if(car.getProductId().equals(id)){
                car.setProductName(updatedProduct.getProductName());
                car.setCarColor(updatedProduct.getCarColor());
                car.setProductQuantity(updatedProduct.getProductQuantity());
                return car;
            }
        }
        return null;
    }
}
