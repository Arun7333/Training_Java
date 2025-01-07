package Day9.vector;

import java.util.Scanner;
import java.util.Vector;

public class GradesManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager gradeManager = new GradeManager();

        //Loop for insertion
        //to end the insertion give -1 as value
        int grade = scanner.nextInt();
        while(grade != -1){
            gradeManager.add(grade);

            grade = scanner.nextInt();
        }

        //Printing the grades
        gradeManager.printGrades();

        //highest, lowest and average
        System.out.println("HighestGrade: " + gradeManager.highestGrade());
        System.out.println("LowestGrade: " + gradeManager.lowestGrade());
        System.out.println("AverageGrade: " + gradeManager.averageGrade());

        //Remove an element
        int indexOfRemoval = scanner.nextInt();
        gradeManager.remove(indexOfRemoval);
    }


}

class GradeManager{
    Vector<Integer> grades;

    GradeManager(){
        grades = new Vector<>();
    }

    public void add(int grade){
        grades.add(grade);
    }

    public void printGrades(){
        System.out.println(grades);
    }

    public void remove(int indexOfRemoval){
        if(grades.size() > indexOfRemoval){
            grades.remove(indexOfRemoval);
            System.out.println("Removed");
        }
        else{
            System.out.println("Index goes beyond the size.");
        }
    }

    public int highestGrade(){
        return grades.stream().max((a, b) -> a - b).orElse(0);
    }

    public int lowestGrade(){
        return grades.stream().min((a, b) -> a - b).orElse(0);
    }

    public int averageGrade(){
        return grades.stream().reduce((a, b) -> a + b).orElse(0) / grades.size();
    }
}
