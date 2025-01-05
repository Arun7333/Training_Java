package Day7.ExtraProblems;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] patterns = new String[n];

        for(int i = 0; i < n; i++){
            patterns[i] = scanner.next();
        }

        String word = scanner.next();

        System.out.println(countContains(patterns, word));
    }

    public static int countContains(String[] patterns, String word){
        int count = 0;

        for(String s : patterns){
            if(word.indexOf(s) >= 0){
                count++;
            }
        }

        return count;
    }
}
