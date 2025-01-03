package Day5.JavaAccessModifiers.AccessModifierExample;

public class Person {
    public String name;
    protected int age;
    String address;
    private int salary;

    public Person(String name, int age, String address, int salary){
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }
}

