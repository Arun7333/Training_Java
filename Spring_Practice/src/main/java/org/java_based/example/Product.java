package org.java_based.example;

public class Product {
    String name;
    int price;

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void show(){
        System.out.println("name " + name+ " price " + price);
    }
}
