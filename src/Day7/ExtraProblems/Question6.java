package Day7.ExtraProblems;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] gains = new int[n];

        for(int i = 0; i < n; i++){
            gains[i] = scanner.nextInt();
        }

        System.out.println(highestAltitude(gains));
    }

    public static int highestAltitude(int[] gains){
        int currAltitude = 0;
        int maxAltitude = 0;

        for(int gain : gains){
            currAltitude += gain;
            maxAltitude = Math.max(currAltitude, maxAltitude);
        }

        return maxAltitude;
    }
}
