package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Product {
    private String productId = "";
    private String productName;
    private int productQuantity;
    private static int productCounter;

    public void ubahProductId(){
        this.setProductId(""+productCounter);
        productCounter++;
    }
}
