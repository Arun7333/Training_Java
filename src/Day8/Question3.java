package Day8;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr){
        int expectedSum = (arr.length * (arr.length + 1)) / 2;

        int sum = Arrays.stream(arr).reduce((a, b) -> a + b).orElse(0);

        return expectedSum - sum;
    }
}
