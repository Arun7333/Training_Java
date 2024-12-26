package Day1;

import java.util.Scanner;

public class Bitwise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int leftShift = number << 2;
        int rightShift = number >> 2;
        System.out.println(leftShift);
        System.out.println(rightShift);
    }
}
