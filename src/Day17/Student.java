package Day17;

public class Student {
    private String name;
    private int marks;

    protected Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    public String getName(){
        return name;
    }

    public int getMarks(){
        return marks;
    }

    public void displayDetails(){
        System.out.println("Name : " + name);
        System.out.println("Marks : " + marks);
    }
}
