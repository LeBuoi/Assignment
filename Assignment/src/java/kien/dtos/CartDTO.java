/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kien.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class CartDTO implements Serializable{
     private Map<String, ProductDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }
    public void add(ProductDTO tea){
        if(this.cart == null){
            this.cart= new HashMap<>();
        }
        if(this.cart.containsKey(tea.getProductID())){
            int quantity = this.cart.get(tea.getProductID()).getQuantity();
            //tea.setQuantity(quantity+1);
            tea.setQuantity(quantity+tea.getQuantity());
            
        }
        cart.put(tea.getProductID(), tea);
    }
    public void delete(String id){
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    public void update(String id, ProductDTO tea){
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.replace(id, tea);
        }
    }
}
