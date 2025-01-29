package StudentManagementSystem.utility;

import java.util.regex.Pattern;

public class Patterns {
    public static Pattern namePattern = Pattern.compile("^[A-Za-z]+(?: [A-Za-z]+)*$");
    public static Pattern emailPattern = Pattern.compile("\\b[\\w.%+-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}\\b");
}
