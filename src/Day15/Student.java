package Day15;

public class Student {
    private String name;
    private int id;
    private String dept;
    private int score;

    public Student(int id, String name, String dept, int score){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public String getDept(){
        return dept;
    }
}
