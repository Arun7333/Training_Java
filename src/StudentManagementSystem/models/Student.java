package StudentManagementSystem.models;

import StudentManagementSystem.exceptions.GradeMisMatchException;

public class Student extends Person {
    private int id;
    private char grade;

    public Student(int id, String name, int age, String email, char grade) {
        super(name, age, email);
        setId(id);
        setGrade(grade);
    }

    public int getId(){
        return id;
    }

    private void setId(int id){
        this.id = id;
    }

    public char getGrade(){
        return grade;
    }

    public void setGrade(char grade){
        //Evaluating the grade
        if(grade < 65 || grade > 68){
            throw new GradeMisMatchException();
        }
        this.grade = grade;
    }

}
