package Day3.StaticVariablesAndMethods;

import java.util.Scanner;

public class Utility {

    public static String convertToUpper(String str){
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(convertToUpper(str));
    }
}
