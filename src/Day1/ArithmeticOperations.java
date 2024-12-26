package Day1;

import java.util.Scanner;

public class ArithmeticOperations {
    public static int Operate(int a, int b, char operator){
        switch(operator){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                break;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        char[] operators = new char[]{'+', '-', '*', '/'};

        for(char operator : operators){
            System.out.println(a + " " + operator + " " + b + ": " + Operate(a, b, operator));
        }
    }
}
