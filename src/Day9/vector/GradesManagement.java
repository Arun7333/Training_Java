package Day9.vector;

import java.util.Scanner;
import java.util.Vector;

public class GradesManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> grades = new Vector<>();

        //Loop for insertion
        //to end the insertion give -1 as value
        int grade = scanner.nextInt();
        while(grade != -1){
            grades.add(grade);

            grade = scanner.nextInt();
        }

        //Printing the grades
        printGrades(grades);

        //highest, lowest and average
        System.out.println("HighestGrade: " + highestGrade(grades));
        System.out.println("LowestGrade: " + lowestGrade(grades));
        System.out.println("AverageGrade: " + averageGrade(grades));

        //Remove an element
        int indexOfRemoval = scanner.nextInt();
        remove(grades, indexOfRemoval);
    }

    public static void printGrades(Vector<Integer> grades){
        System.out.println(grades);
    }

    public static void remove(Vector<Integer> grades, int indexOfRemoval){
        if(grades.size() > indexOfRemoval){
            grades.remove(indexOfRemoval);
            System.out.println("Removed");
        }
        else{
            System.out.println("Index goes beyond the size.");
        }
    }

    public static int highestGrade(Vector<Integer> grades){
        return grades.stream().max((a, b) -> a - b).orElse(0);
    }

    public static int lowestGrade(Vector<Integer> grades){
        return grades.stream().min((a, b) -> a - b).orElse(0);
    }

    public static int averageGrade(Vector<Integer> grades){
        return grades.stream().reduce((a, b) -> a + b).orElse(0) / grades.size();
    }
}
