package Day1;

import java.util.Scanner;

public class LogicalAndRelational {
    public static boolean isRelational(int a, int b, String operator){
        switch(operator){
            case "==":
                return a == b;
            case "!=":
                return a != b;
            case ">":
                return a > b;
            case "<":
                return a < b;
            default:
                break;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String[] operators = new String[]{"==", "!=", ">", "<"};

        for(String operator : operators){
            System.out.println(a + " " + operator + " " + b + ": " + isRelational(a, b, operator));
        }

        System.out.println(true && true);
        System.out.println(true || false);
        System.out.println(!true);
        System.out.println(true ^ false);

    }
}
