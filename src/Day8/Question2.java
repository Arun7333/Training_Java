package Day8;

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        rotateArray(arr, k);

        Arrays.stream(arr).forEach(num -> System.out.println(num));
    }

    public static void rotateArray(int[] arr, int k){

        rotate(arr, 0, arr.length - 1);

        if(k == arr.length) return;

        rotate(arr, 0, k - 1);

        rotate(arr, k, arr.length-1);
    }

    public static void rotate(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
