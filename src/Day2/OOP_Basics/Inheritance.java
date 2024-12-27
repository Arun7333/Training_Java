package Day2.OOP_Basics;

public class Inheritance {
    public static void main(String[] args) {
        Animal dog = new Dog("Husky");
        dog.speak();
        Animal cat = new Cat("Orange");
        cat.speak();
    }
}

abstract class Animal{
    private String name;

    Animal(String name){
        this.name = name;
    }

    public void display(){
        System.out.println(name);
    }

    public abstract void speak();
}

class Dog extends Animal{
    Dog(String name){
        super(name);
    }

    public void speak(){
        System.out.println("Barking!");
    }
}

class Cat extends Animal{
    Cat(String name){
        super(name);
    }

    public void speak(){
        System.out.println("Meowing!");
    }
}
