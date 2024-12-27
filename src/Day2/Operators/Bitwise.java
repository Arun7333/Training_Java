package Day2.Operators;

import java.util.Scanner;

public class Bitwise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After Swapping: " + a + " " + b);

        int num = scanner.nextInt();
        System.out.println("The 1's count of " + num + " is: " + onesCount(num));
    }


    //To find the 1's count in binary representation of a number
    public static int onesCount(int num){
        int count = 0;

        while(num > 0){
            if(num % 2 != 0) count++;
            num /= 2;
        }

        return count;
    }

}
