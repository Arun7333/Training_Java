package Day1;

import java.util.Scanner;

public class Ternary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println(number%2 == 0 ? "Even" : "Odd");
    }
}
