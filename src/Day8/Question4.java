package Day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        int[] indexes = twoSum(arr, target);

        if(indexes.length > 0){
            System.out.println("Indexes are: " + indexes[0] + " " + indexes[1]);
        }
        else System.out.println("No pairs found!");

        return;
    }

    public static int[] twoSum(int[] arr, int target){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int remaining = target - arr[i];

            if(map.containsKey(remaining)){
                return new int[]{map.get(remaining), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{};
    }
}

