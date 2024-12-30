package Day3.InheritancePart2;

public class HierarchicalInheritance {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();

        animal = new Cat();
        animal.sound();
    }
}

class Animal{

    public void sound(){
        System.out.println("oooooh!");
    }
}

class Dog extends Animal{

    public void sound(){
        System.out.println("Bark!");
    }
}

class Cat extends Animal{

    public void sound(){
        System.out.println("Meoww!");
    }
}