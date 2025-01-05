package Day7.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int c = a/b;
            System.out.println("Division of " + a + " and " + b + " is " + c);
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero is not allowed.");
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter numeric values.");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
