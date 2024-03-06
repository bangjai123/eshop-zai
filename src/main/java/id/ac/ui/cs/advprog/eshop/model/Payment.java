package id.ac.ui.cs.advprog.eshop.model;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
public class Payment {
    String id;
    String method;

    @Setter
    String status;
    Map<String,String> map;

    public Payment(String id, String method, Map<String,String> map, Order order){
    }

    public Payment(String id, String method, Map<String,String> map, Order order, String status){
    }
}
