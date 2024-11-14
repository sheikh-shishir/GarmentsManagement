package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;


class Garment{
    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity ;
    
    public Garment(String id,String name,String description,String size,String color,double price,int stockQuantity)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
        
    }
    
    public void updateStock(int quantity)
    {
        this.stockQuantity = quantity;
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
    
    public Fabric(String id,String type,String color,double pricePerMeter)
    {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }
    
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
    
    public Supplier(String id,String name,String contactInfo)
    {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }
    
    public void addFabric(Fabric fabric) 
    {
        suppliedFabrics.add(fabric);
    }
    public List<Fabric> getSuppliedFabrics()
    {
        return suppliedFabrics;
    }
}

class Order{
    public String orderId ;
    public String orderDate ;
    public List<Garment> garments = new ArrayList<>();
    public double totalAmount;
    
    public Order(String orderId,String orderDate,double totalAmount)
    {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    
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
        System.out.println("--------------------------");
        System.out.println("Order Details : ");
        System.out.println("--------------------------");
        for(Garment g : garments)
        {
            
            System.out.println("name : "+g.name);
            System.out.println("color : "+g.color);
            System.out.println("Price : "+g.price);
            System.out.println("Description : "+g.description);
            System.out.println("--------------------------");
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
        order.printOrderDetails();
        System.out.println("Order Placed");
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
        for(Garment g : garments)
        {
            if(g.id == id)
            {
                return g;
            }
        }
        return null;
        
    }
}


public class Main {

    public static void main(String[] args) {
        
        Garment g1 = new Garment("1","silk","good product","XL","Red",600,1000);
        
        System.out.println(g1.calculateDiscountPrice(g1.price)) ;
        
        g1.updateStock(15);
        
        Fabric f1 = new Fabric("1","silk","blue",10);
        System.out.println(f1.calculateCost(10));
        
        
        Supplier s1 = new Supplier("1","12","01799809062");
        s1.addFabric(f1);
        System.out.println(s1.getSuppliedFabrics());
        
        Order o1 = new Order("100","1988-09-29",1000);
        o1.addGarment(g1);
        o1.printOrderDetails();
        

         
    }
}

