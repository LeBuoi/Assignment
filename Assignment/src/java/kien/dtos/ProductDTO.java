/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kien.dtos;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class ProductDTO implements Serializable{
    private String productID;
    private String Name;
    private int Quantity;
    private double Price;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String Name, int Quantity, double Price) {
        this.productID = productID;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    
    
}
