package Day2.Library;

public class bookNotAvailable extends Exception {
    public bookNotAvailable() {
        super("Book is not Available!");
    }
}
