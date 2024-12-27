package Day2.ProgramControl;

import java.util.Scanner;

public class DecisionMaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        System.out.println("The given year is a " + (isLeapYear(year) ? "Leap year." : "Non leap year." ));

        // The input pattern is
        //  Eg : a + b
        int a = scanner.nextInt();
        String opr = scanner.next();
        int b = scanner.nextInt();

        System.out.println(calculator(a, b, opr));

    }

    public static int calculator(int a, int b, String opr){

        switch(opr){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0);
    }
}
