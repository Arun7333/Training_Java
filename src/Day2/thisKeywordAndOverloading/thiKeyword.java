package Day2.thisKeywordAndOverloading;

public class thiKeyword {
    public static void main(String[] args) {

    }
}

class Employee{
    public int id;
    public String name;
    public int salary;

    Employee(int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
