package Day8;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(largestSum(arr));
    }

    public static int largestSum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : arr){
            sum += num;
            if(sum > maxSum) maxSum = sum;
            if(sum < 0) sum = 0;
        }

        return maxSum;
    }
}
