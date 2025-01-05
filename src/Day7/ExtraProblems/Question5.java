package Day7.ExtraProblems;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] positions = new int[n];

        for(int i = 0; i < n; i++){
            positions[i] = scanner.nextInt();
        }

        System.out.println(minimumCost(positions));
    }

    public static int minimumCost(int[] positions){
        int oddCount = 0;
        int evenCount = 0;

        //Moving chips between same type of numbers like odd or even doesn't cost.
        //But moving between diff type of numbers cost 1.
        //So we are moving the lesser type greedily to get minimum cost.

        for(int position : positions){
            if(position % 2 == 0) evenCount++;
        }

        oddCount = positions.length - evenCount;

        return Math.min(evenCount, oddCount);
    }
}
