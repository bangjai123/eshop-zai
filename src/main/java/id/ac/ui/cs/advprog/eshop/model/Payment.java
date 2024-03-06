package id.ac.ui.cs.advprog.eshop.model;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
public class Payment {
    String id;
    String method;
    Map<String,String> map;

    //diasumsikan hanya ada dua kemungkina, SUCCESS atau REJECTED
    String status;

    //diasumsikan setiap payment adalah pasti terhubung dengan sebuah order
    Order order;

    public Payment(String id, String method, Map<String,String> map, Order order){
        this.id = id;
        this.map = map;

        if(order.equals(null)||!PaymentMethod.contains(method)){
            throw new IllegalArgumentException();
        }
        else{
            this.order = order;
            this.method = method;
        }
    }

    public Payment(String id, String method, Map<String,String> map, Order order, String status){
       this(id,method,map,order);
       this.setStatus(status);
    }
    public void setStatus(String status){
        if(PaymentStatus.contains(status)){
            this.status = status;

        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
