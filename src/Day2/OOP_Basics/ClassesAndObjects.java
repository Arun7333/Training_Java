package Day2.OOP_Basics;

public class ClassesAndObjects {
    public static void main(String[] args) {

    }
}

class Car{
    public String brand;
    public String model;
    public float price;

    Car(String brand, String model, float price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void display(){
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public float calculateDiscount(int discountPercentage){
        return price * (1 - (float) (discountPercentage / 100));
    }
}