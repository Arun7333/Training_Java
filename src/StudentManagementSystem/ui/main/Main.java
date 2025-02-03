package StudentManagementSystem.ui.main;

import StudentManagementSystem.services.StudentManager;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        try {
            manager.setDirectory("C:\\Users\\Arun P\\OneDrive\\Desktop\\Students");
        }
        catch (Exception e){
            out.println(e.getMessage());
        }

        GUI gui = new GUI(manager);
    }
}
