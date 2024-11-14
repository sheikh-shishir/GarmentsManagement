

package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author macbookair
 */

class Garment{
    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity ;
    
    public void updateStock(int quantity)
    {
        stockQuantity = stockQuantity + 1;
        System.out.println("Current Stock is : "+stockQuantity);
    }
    public double calculateDiscountPrice(double discountPercentage)
    {
        return price * discountPercentage/100;
    }
}

class Fabric{
    public String id;
    public String type ;
    public String color;
    public double pricePerMeter;
    
    public double calculateCost(double meters)
    {
        return pricePerMeter * meters;
    }
    
//    List<Fabric> getSuppliedFabric();
}

class  Supplier{
    public String id;
    public String name;
    public String contactInfo;
    private List<Fabric> suppliedFabrics = new ArrayList<>();
    
    public void addFabric(Fabric fabric) 
    {
        
    }
    public List<Fabric> getSuppliedFabrics()
    {
        return suppliedFabrics;
    }
}

class Order{
    public String orderId ;
    public Date orderDate ;
    public List<Garment> garments = new ArrayList<>();
    public double totalAmount;
    
    public void addGarment(Garment garment) 
    {
        garments.add(garment);
    }
    public double calculateTotalAmount() {
        for(Garment g : garments)
        {
            totalAmount += g.price;
        }
        return totalAmount;
    }
    public void printOrderDetails() 
    {
        System.out.println("Order Details : ");
        for(Garment g : garments)
        {
            
            System.out.println("name : "+g.name);
            System.out.println("color : "+g.color);
        }
    }
}

class Customer
{
    public String customerId ;
    public String name;
    public String email;
    public String phone ;
    
    public void placeOrder(Order order)
    {
        
    }
    public List<Order> viewOrders() 
    {
        return null;
    }
}

class Inventory{
    public List<Garment> garments = new ArrayList<>();
    
    public void addGarment(Garment garment)
    {
        garments.add(garment);
    }
    public void removeGarment(String id)
    {
        garments.remove(id);
    }
    public Garment findGarment(String id)
    {
        
        return null;
        
    }
}


public class Main {

    public static void main(String[] args) {
        
        Garment g1 = new Garment();
        g1.name = "silk";
        g1.color = "red";
        g1.price = 5;
        g1.id ="1";
        System.out.println(g1.calculateDiscountPrice(g1.price)) ;
        g1.updateStock(15);
        
         
    }
}

