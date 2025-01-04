package Day6.ExceptionHandling;

/*
    Write a program that:
    Accepts two integers from the user as input.
       Attempts to divide the first integer by the second.
    Implements exception handling to manage the following scenarios:
    Division by zero: Display an error message "Error: Division by zero is not allowed.".
    Invalid input: Display an error message "Error: Please enter valid integers.".
    Any other exceptions: Display "An unexpected error occurred.".
*/

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a / b);
        }
        catch(ArithmeticException e){
            System.out.println("Error: Division by zero is not allowed.");
        }
        catch(NumberFormatException e){
            System.out.println("Error: Please enter valid integers.");
        }
        catch(Exception e){
            System.out.println("An unexpected error occurred.");
        }
    }
}
