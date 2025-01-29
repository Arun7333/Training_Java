package StudentManagementSystem.main;

import StudentManagementSystem.models.Student;
import StudentManagementSystem.services.StudentManager;
import static java.lang.System.out;
import java.util.Scanner;

public class Main{
    public static String[][] menu = new String[][]{
            {"Create Student", "create"},
            {"Delete Student", "delete"},
            {"Update Student", "update"},
            {"Show All Students", "showAll"},
            {"Exit", "exit"}
    };
    public static StudentManager manager = new StudentManager();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        out.println("Menu :");
        out.println("Menu and their commands separated by '->'");
        for (String[] value : menu){
            out.println(value[0] + " -> " + value[1]);
        }

        String option = "";
        while(true){
            out.print("Enter the command: ");
            option = in.nextLine().trim();

            switch (option){
                case "create":
                    createStudent();
                    out.println("_____________________________________");
                    break;
                case "delete":
                    deleteStudent();
                    out.println("_____________________________________");
                    break;
                case "update":
                    updateStudent();
                    out.println("_____________________________________");
                    break;
                case "showAll":
                    manager.showAll();
                    out.println("_____________________________________");
                    break;
                case "exit":
                    out.print("Shutting down.");
                    load();
                    System.exit(0);
                default:
                    out.println("Please, give a correct command!");
            }
        }
    }

    public static void createStudent(){
        int age;
        String name, email;
        char grade;

        try{
            out.print("Enter your Name: ");
            name = in.nextLine();

            out.print("Enter your Age: ");
            age = in.nextInt();
            in.nextLine();

            out.print("Enter your Email: ");
            email = in.nextLine();

            out.print("Enter your Grade: ");
            grade = in.next().charAt(0);
            in.nextLine();

            Student student = manager.newStudent(name, age, email, grade);
            manager.add(student);
        }
        catch (Exception e){
            out.println(e.getMessage());
        }
    }

    public static void deleteStudent(){
        int id;

        try{
            out.print("Enter the id of the student to be removed: ");
            id = in.nextInt();
            in.nextLine();

            manager.remove(id);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public static void updateStudent(){
        int id;

        try {
            out.print("Enter the id of the student to be updated: ");
            id = in.nextInt();
            out.println();

            out.println("Syntax for update command is:\n" +
                    "(Field to be updated) (Value to be updated)\n" +
                    "For eg: Name Arun"
            );

            String field = in.next();
            switch (field){
                case "Name":
                    String name = in.nextLine();
                    manager.updateName(id, name);
                    break;
                case "Age":
                    int age = in.nextInt();
                    in.nextLine();
                    manager.updateAge(id, age);
                    break;
                case "Email":
                    String email = in.next();
                    manager.updateEmail(id, email);
                    break;
                case "Grade":
                    char grade = in.next().charAt(0);
                    in.nextLine();
                    manager.updateGrade(id, grade);
                    break;
                default:
                    out.println("Field name is invalid, Check the command and try again");
                    break;
            }
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }

    public static void load(){
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                out.print(".");
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
