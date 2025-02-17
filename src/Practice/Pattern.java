package Practice;

import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        printPattern(n);
    }

    public static void printPattern(int n){
        if(n <= 0) return;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){
                if(i == 0 || i == n-1 || j == 0 || j == n-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }

                if(j != n-1){
                    System.out.print(" ");
                }
            }

            if(i != n-1){
                System.out.println();
            }
        }
    }
}
