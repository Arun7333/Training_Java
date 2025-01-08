package Day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StudentGradeManager gradeManager = new StudentGradeManager();

        //Adding the students and grades
        for(int i = 0; i < n; i++){
            String name = scanner.next();
            int grade = scanner.nextInt();

            gradeManager.add(name, grade);
        }

        //Update a student record
        String name = scanner.next();
        int gradeToBeChanged = scanner.nextInt();

        gradeManager.update(name, gradeToBeChanged);

        //Retrieve a student grade
        name = scanner.next();
        System.out.println("Grade of " + name + " is " + gradeManager.get(name));

        //Display all the students and their grade
        gradeManager.display();
    }
}

class StudentGradeManager{
    private Map<String, Integer> grades;

    StudentGradeManager(){
        grades = new HashMap<>();
    }

    public void add(String name, int grade){
        grades.put(name, grade);
    }

    public void update(String name, int grade){
        if(grades.containsKey(name)){
            this.add(name, grade);
        }
        else System.out.println(name + " is not available!");
    }

    public int get(String name){
        return grades.get(name);
    }

    public void display(){
        System.out.println("Students and their grades: ");
        for(String name : grades.keySet()){
            System.out.println(name + " : " + grades.get(name));
        }
    }
}
