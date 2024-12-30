package Day3.InheritancePart1;

public class BasicInheritance {
    public static void main(String[] args) {
        Person person = new Student("Arun", 21, 01);
        person.showDetails();

        Vehicle vehicle = new Car();
        vehicle.start();
    }
}

class Person{
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void showDetails(){
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
    }
}

class Student extends Person{
    private int rollNo;
    private int mark;

    Student(String name, int age, int rollNo){
        super(name, age);
        this.rollNo = rollNo;
        this.mark = 0;
    }

    public int getRollNo(){
        return rollNo;
    }

    public int getMark(){
        return mark;
    }

    public void setMark(int mark){
        this.mark = mark;
    }

    public void showDetails(){
        super.showDetails();
        System.out.println("RollNo: " + this.getRollNo());
        System.out.println("Marks: " + this.getMark());
    }
}


class Vehicle{
    public void start(){
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle{
    public void start(){
        System.out.println("Car Started");
    }
}
