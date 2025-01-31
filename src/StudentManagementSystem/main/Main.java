package StudentManagementSystem.main;

import StudentManagementSystem.exceptions.StudentNotAvailableException;
import StudentManagementSystem.models.Student;
import StudentManagementSystem.services.StudentManager;
import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Main{
    public static String[][] menu = new String[][]{
            {"Create Student", "create"},
            {"Delete Student", "delete"},
            {"Update Student", "update"},
            {"Get Student", "get"},
            {"Read from a text file", "read"},
            {"Read from a directory", "readDir"},
            {"Show All Students", "showAll"},
            {"Sort Students", "sort"},
            {"Filter Students", "filter"},
            {"Exit", "exit"}
    };
    public static StudentManager manager = new StudentManager();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        out.println("Menu and their commands separated by '->'");
        out.println("Menu :");
        for (String[] value : menu){
            out.println(value[0] + "  ->  " + value[1]);
        }

        out.println("\nNote ::: Before starting you have to give the path to the directory in which the objects to be written");
        String directoryPath;
        boolean pathSetted = false;

        //Setting the home directory where to save the files
        while(!pathSetted) {
            try {
                out.print("Enter the directory path, where you want to save the objects: ");
                directoryPath = in.nextLine();
                manager.setDirectory(directoryPath);
                pathSetted = true;
            }
            catch (Exception e) {
                out.println(e.getMessage());
            }
        }


        //_________
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
                case "get":
                    getStudent();
                    out.println("_____________________________________");
                    break;
                case "readFile":
                    readFile();
                    out.println("_____________________________________");
                    break;
                case "readDir":
                    readDirectory();
                    out.println("_____________________________________");
                    break;
                case "showAll":
                    manager.showAll();
                    out.println("_____________________________________");
                    break;
                case "sort":
                    sort();
                    out.println("_____________________________________");
                    break;
                case "filter":
                    filter();
                    out.println("_____________________________________");
                    break;
                case "exit":
                    load(10, "Shutting down.");
                    manager.completeTasks();
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

            out.print("Enter your Grade(A, B, C, D): ");
            grade = in.next().charAt(0);
            in.nextLine();

            Student student = manager.newStudent(name, age, email, grade);
            manager.add(student);
            out.println("~~Student successfully created~~");
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
            out.println("~~Student with id " + id + " is successfully deleted~~");
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public static void updateStudent(){
        int id;

        out.print("Enter the id of the student to be updated: ");
        id = in.nextInt();
        in.nextLine();

        //check the student availability
        if(manager.get(id).isEmpty()){
            out.println("Caught : Student with this id not available!");
            return;
        }

        out.println("\nNote ::: Syntax for update command is: " +
                "(Field to be updated in lowercase) (Value to be updated) " +
                "For eg: \"name Arun\"\n" +
                "Enter \"back\" to go back home..."
        );

        out.print("Enter your update command: ");
        String field = in.next();
        while(true) {
            if(field.equals("back")){
                in.nextLine();
                load(5, "coming back to home.");
                out.println();
                break;
            }

            try {
                switch (field) {
                    case "name":
                        String name = in.nextLine();
                        manager.updateName(id, name);
                        out.println("~~Name successfully changed~~");
                        break;
                    case "age":
                        int age = in.nextInt();
                        in.nextLine();
                        manager.updateAge(id, age);
                        out.println("~~Age successfully changed~~");
                        break;
                    case "email":
                        String email = in.nextLine();
                        manager.updateEmail(id, email);
                        out.println("~~Email successfully changed~~");
                        break;
                    case "grade":
                        char grade = in.next().charAt(0);
                        in.nextLine();
                        manager.updateGrade(id, grade);
                        out.println("~~Grade successfully changed~~");
                        break;
                    default:
                        in.nextLine();
                        out.println("Field name is invalid, Check the command and try again");
                        break;
                }
            }
            catch(Exception e){
                out.println("Caught : " + e.getMessage());
            }

            out.print("Enter your update command: ");
            field = in.next();
        }
    }

    public static void getStudent(){
        int id;

        try{
            out.print("Enter the id of the student to get: ");
            id = in.nextInt();
            in.nextLine();

            Optional<Student> optionalStudent = manager.get(id);
            optionalStudent.ifPresentOrElse(out::println, () ->{
                throw new StudentNotAvailableException();
            });
        }
        catch (Exception e){
            out.println(e.getMessage());
        }
    }

    public static void readFile(){
        String filePath;

        try{
            out.print("Enter the file path from where to read(must be text file): ");
            filePath = in.nextLine();

            manager.readFromFile(filePath);
            out.println("~~Successfully read from the file " + filePath + " ~~");
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }

    public static void readDirectory(){
        String directoryPath;

        try{
            out.print("Enter the directory path from where to read(must be directory): ");
            directoryPath = in.nextLine();

            manager.readFromDirectory(directoryPath);
            out.println("~~Successfully read all the text files from the directory " + directoryPath + " ~~");
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }

    public static void sort(){
        String field;

        out.print("Enter the field name used for sorting in lowercase(ForEg : name) : ");
        field = in.nextLine().trim().toLowerCase();

        manager.sortByField(field);
    }

    public static void filter(){
        String field;

        out.print("Enter the field name used for filtering in lowercase(ForEg : name) : ");
        field = in.nextLine().trim().toLowerCase();

        switch (field){
            case "grade":
                out.print("Enter the grade you want to filter: ");
                char grade = in.nextLine().charAt(0);
                manager.filterByField(field, grade);
                break;
            case "age":
                out.print("Enter the age you want to filter: ");
                int age = in.nextInt();
                in.nextLine();
                manager.filterByField(field, age);
                break;
            default:
                out.println("Invalid field (or) the field you given is always unique, Try again!");
        }
    }

    public static void load(int n, String message){
        out.print(message);
        for (int i = 0; i < n; i++) {
            try {
                out.print(".");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
