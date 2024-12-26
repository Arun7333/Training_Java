package Day1;

import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float floatNumber = scanner.nextFloat();
        int intNumber = (int) floatNumber;
        System.out.println(intNumber);
    }
}
