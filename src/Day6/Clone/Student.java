package Day6.Clone;

public class Student implements Cloneable{
    private String name;
    private int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
