package Day3.Polymorphism;

public class Runtime {
    public static void main(String[] args) {
        Employee employee = new Developer("Arun", 100000, 20000);
        System.out.println(employee.calculateSalary());
    }
}

class Employee{
    protected String name;
    protected int baseSalary;

    Employee(String name, int baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int calculateSalary(){
        return baseSalary;
    }
}

class Manager extends Employee{
    private int bonus;

    Manager(String name, int baseSalary, int bonus){
        super(name, baseSalary);
        this.bonus = bonus;
    }

    public int calculateSalary(){
        return baseSalary + bonus;
    }
}

class Developer extends Employee{
    private int overTime;

    Developer(String name, int baseSalary, int overTime){
        super(name, baseSalary);
        this.overTime = overTime;
    }

    public int calculateSalary(){
        return baseSalary + overTime;
    }
}