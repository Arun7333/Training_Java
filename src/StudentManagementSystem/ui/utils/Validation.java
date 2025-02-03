package StudentManagementSystem.ui;

import StudentManagementSystem.utility.Patterns;

import java.awt.*;
import java.util.regex.Matcher;

public class Validation {

    public static boolean isName(String name){
        Matcher nameMatcher = Patterns.namePattern.matcher(name);

        return nameMatcher.matches();
    }

    public static boolean isAge(int age){
        return age >= 5 && age <= 120;
    }

    public static boolean isEmail(String email){
        Matcher emailMatcher = Patterns.emailPattern.matcher(email);

        return emailMatcher.matches();
    }

    public static boolean isGrade(String grade){
        boolean flag = false;

        if(grade.length() == 1){
            for(int i = 0; i < GUI.grades.length; i++){
                if(grade.charAt(0) == GUI.grades[i]){
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }
}
