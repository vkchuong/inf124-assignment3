/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s2020iae.project3;

/**
 *
 * @author anon
 */
public class Items {
    
    private Product product;
    private int quantity;
    private float price;
    

    public Items (Product product,int quantity,float price){
        this.product=product;
        this.quantity=quantity;
        this.price=price;
    }
    
    public Product getProduct()
    {
        return product;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
    public void setPrice(int price){
        this.price=price;
    }
    
    public void setProduct(Product product){
        this.product= product;
    }
}
