package id.ac.ui.cs.advprog.eshop.model;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
public class Payment {
    String id;
    String method;
    Map<String,String> map;
    String status;

    //diasumsikan setiap payment adalah pasti terhubung dengan sebuah order
    Order order;

    public Payment(String id, String method, Map<String,String> map, Order order){
        this.id = id;
        this.map = map;

        if(order.equals(null)||!methodIsValid(method)){
            throw new IllegalArgumentException();
        }
        else{
            this.order = order;
            this.method = method;
        }

    }

    public Payment(String id, String method, Map<String,String> map, Order order, String status){
       this(id,method,map,order);

       if(statusIsValid(status)){
           this.status = status;
       }
       else{
           throw new IllegalArgumentException();
       }
    }

    public boolean methodIsValid(String method){
        //asumsi hanya dua pilihan karena NPM saya ganjil sehingga hanya perlu voucher dan COD
        if (method.equals("CashOnDelivery")||method.equals("Voucher")){
            return true;
        }
        return false;
    }

    public boolean statusIsValid(String status){
        if(status.equals("SUCCESS")||status.equals("REJECTED")){
            return true;
        }
        return false;
    }

    public void setStatus(String status){
        if(!statusIsValid(status)){
            throw new IllegalArgumentException();
        }
        else{
            this.status = status;
        }
    }
}
