package Day2.OOP_Basics;

import java.util.Arrays;

public class Polymorphism {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        Calculator obj = new Calculator();
        System.out.println(obj.add(arr));
    }
}

class Calculator{

    public int add(int a, int b){
        return a + b;
    }

    public float add(float a, float b){
        return a + b;
    }

    public int add(int[] arr){
        return Arrays.stream(arr).sum();
    }

}
