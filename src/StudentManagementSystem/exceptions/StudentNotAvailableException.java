package StudentManagementSystem.exceptions;

public class StudentNotAvailableException extends RuntimeException {
    public StudentNotAvailableException() {
        super("Student with that id is not available!");
    }
}
