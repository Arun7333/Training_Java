package Day2.ProgramControl;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        pyramidPattern(n);

        int numToReverse = scanner.nextInt();

        System.out.println("The reversed number is: " + reverseNum(numToReverse));
    }

    //Method to print pyramid for given size
    public static void pyramidPattern(int size){

        for(int row = 0; row < size; row++){
            //loop for space
            for(int space = 0; space < size-row-1; space++){
                System.out.print(" ");
            }

            //loop for star
            for(int star = 0; star < row + 1; star++){
                if(star != row){
                    System.out.print("* ");
                }
                else System.out.println("*");
            }
        }
    }

    //Method to reverse the given number
    public static int reverseNum(int num){
        int resultNum = 0;
        int multiplier = 10;

        while(num > 0){
            int currDigit = num % 10;
            resultNum *= multiplier;
            resultNum += currDigit;

            num /= 10;
        }

        return resultNum;
    }
}
