package Day2.Operators;

import java.util.Scanner;

public class Ternary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.print(
                "The largest number is: "
                + ((a > b) ? (a > c) ? a : c : (b > c) ? b : c)
        );

    }
}
