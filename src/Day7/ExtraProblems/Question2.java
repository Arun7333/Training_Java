package Day7.ExtraProblems;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sequence = scanner.next();
        String word = scanner.next();

        System.out.println(kRepeating(sequence, word));
    }

    public static int kRepeating(String sequence, String word){
        int m = sequence.length();
        int n = word.length();
        int count = 0;

        for(int i = 0; i < m; i++){
            if(sequence.charAt(i) != word.charAt(0)){
                while(++i < m && sequence.charAt(i) != word.charAt(0));
            }

            if(i < m){
                int start = i;
                int expectedEnd = i + n;
                boolean isAvailable = true;

                for(int j = 0; j < n && start < m; j++){
                    if(sequence.charAt(start++) == word.charAt(j)) continue;
                    else{
                        isAvailable = false;
                        break;
                    }
                }

//                System.out.println("end!");

                if(start == expectedEnd && isAvailable){
                    count++;
                    i = start - 1;
//                    System.out.println("setted: " + i);
                }
            }
        }

        return count;
    }
}
