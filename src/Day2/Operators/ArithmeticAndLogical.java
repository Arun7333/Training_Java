package Day2.Operators;

import java.util.Scanner;

public class ArithmeticAndLogical {

    //To find factorial of a number
    //The 13! will exceeds the max value of an integer and it will overflow
    //So, we use long, it will holds upto 20!
    public static long factorial(int num){
        if(num == 0) return 0;

        long result = 1;

        for(int i = 2; i <= num; i++){
            result *= i;
        }

        return result;
    }


    //To find a number is Prime or not
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num <= 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;

        /*
            While finding isPrime for largest prime integer there will be occur integer overflow.
            so, we use long to check the conditions in for loop.
        */

        for(int curr = 5; (long) curr * curr <= num; curr += 6){
            if(num % curr == 0 || num % (curr+2) == 0){
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println("Factorial of " + num + " is: " + factorial(num));

        int num2 = scanner.nextInt();

        System.out.println("The given number " + num2 + " is: " + (isPrime(num2) ? "Prime" : "Not Prime"));
    }
}
