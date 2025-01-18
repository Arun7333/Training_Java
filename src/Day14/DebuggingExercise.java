package Day14;

import java.util.Scanner;

public class DebuggingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] marks = new int[numStudents];
        int totalMarks = 0;

        // Collect marks
        System.out.println("Enter marks for " + numStudents + " students:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average
        double averageMarks = totalMarks / numStudents;

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
    }
}

