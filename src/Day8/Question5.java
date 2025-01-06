package Day8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int[] rightMax = findRightMax(arr);

        Arrays.stream(rightMax).forEach(System.out::println);
    }

    public static int[] findRightMax(int[] arr){
        int n = arr.length;
        if(n == 0) return new int[]{};

        int[] rightMaxArr = new int[n];
        Stack<Integer> monotonicStack = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!monotonicStack.isEmpty() && arr[i] > monotonicStack.peek()) monotonicStack.pop();

            if(monotonicStack.isEmpty()){
                rightMaxArr[i] = -1;
            }
            else{
                rightMaxArr[i] = monotonicStack.peek();
            }

            monotonicStack.push(arr[i]);
        }

        return rightMaxArr;
    }
}
