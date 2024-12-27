package Day2.ProgramControl;

import java.util.Scanner;

public class JumpStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //using continue
        for(int i = 1; i <= 100; i++){
            if(i % 5 == 0) continue;
            System.out.println(i);
        }

        //using break
        System.out.println("using Break:");
        int input = scanner.nextInt();
        while(input != 0){
            input = scanner.nextInt();
        }
    }
}
