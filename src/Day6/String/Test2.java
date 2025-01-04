package Day6.String;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        //Lexographically greater String
        if(str1.compareTo(str2) == 1){
            System.out.println(str1 + " is lexographically greater than " + str2);
        }
        else if(str1.compareTo(str2) == 0){
            System.out.println(str1 + " is equal to " + str2);
        }
        else{
            System.out.println(str2 + " is lexographically greater than " + str1);
        }

        //case sensitively equal
        if (str1.equals(str2)) {
            System.out.println(str1 + " is case sensitively equal with " + str2);
        }
        else System.out.println(str1 + " is case sensitively not equal with " + str2);

        //case insensitively equal
        if(str1.toLowerCase().equals(str2.toLowerCase())){
            System.out.println(str1 + " is case insensitively equal with " + str2);
        }
        else System.out.println(str1 + " is case insensitively not equal with " + str2);

        //concatenation of two strings
        System.out.println("Concatenated String: " + (str1 + str2));
    }
}
