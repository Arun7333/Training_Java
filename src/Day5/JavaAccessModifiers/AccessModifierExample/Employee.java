package Day5.JavaAccessModifiers.AccessModifierExample;

public class Employee extends Person{
    private int id;

    public Employee(int id, String name, int age, String address, int salary){
        super(name, age, address, salary);
        this.id = id;
    }

    public void getAccessible(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        //Salary is private, So cannot be accessed from outside
        //System.out.println(salary);
    }
}
