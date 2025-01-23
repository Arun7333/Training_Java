package Day18;

import java.util.Arrays;

public class Student {
    private String name;
    private int[] marks;
    private char grade;
    private String dept;
    private int averageMark;

    Student(String name, String dept, int[] marks){
        this.name = name;
        this.marks = marks.clone();
        this.dept = dept;
        averageMark = -1;
        setAverageMark();
    }

    public int getAverageMark(){
        setAverageMark();

        return averageMark;
    }

    public String getName(){
        return name;
    }

    private void setAverageMark(){
        if(averageMark == -1) {
            averageMark = Arrays.stream(marks).sum() / marks.length;
        }
    }

    public void setMark(int index, int mark){
        if(index < marks.length){
            marks[index] = mark;
            averageMark = -1;
        }
    }

    public void setGrade(char grade){
        this.grade = grade;
    }

    public char getGrade(){
        return grade;
    }

    public String getDepartment(){
        return dept;
    }
}
