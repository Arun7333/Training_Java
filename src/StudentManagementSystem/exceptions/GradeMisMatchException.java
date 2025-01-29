package StudentManagementSystem.exceptions;

public class GradeMisMatchException extends RuntimeException {
    public GradeMisMatchException() {
        super("Given grade is mismatching!");
    }
}
