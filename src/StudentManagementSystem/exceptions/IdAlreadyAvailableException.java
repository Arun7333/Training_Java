package StudentManagementSystem.exceptions;

public class IdAlreadyAvailableException extends RuntimeException {
    public IdAlreadyAvailableException() {
        super("Student with this id already available!");
    }
}
