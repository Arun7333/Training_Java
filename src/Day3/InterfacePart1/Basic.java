package Day3.InterfacePart1;

public class Basic {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
    }
}

interface Animal{
    int num = 10;

    public void eat();

    public void sleep();
}

class Dog implements Animal{

    public void eat(){
        System.out.println("Dog is eating!");
    }

    public void sleep(){
        System.out.println("Dog is sleeping!");
    }

    public void stop(){

    }
}

class Cat implements Animal{

    public void eat(){
        System.out.println("Cat is eating!");
    }

    public void sleep(){
        System.out.println("Cat is sleeping!");
    }
}


