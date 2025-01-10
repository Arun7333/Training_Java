package Day11;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern emailPattern = Pattern.compile("\\b[\\w.%+-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}\\b");
        Matcher emailMatcher = emailPattern.matcher(" ");

        int n = scanner.nextInt();
        String[] emails = new String[n];

        for(int i = 0; i < n; i++){
            emails[i] = scanner.next();
        }

        //Validating all the emails
        for(String email : emails){
            emailMatcher.reset(email);//resetting the matcher with new strings

            if(emailMatcher.matches()){
                System.out.println(email + " is valid.");
            }
            else{
                System.out.println(email + " is invalid.");
            }
        }
    }
}
