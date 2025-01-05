package Day7.ExtraProblems;

import java.util.*;
interface AdvancedArithmetic{
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{

    @Override
    public int divisor_sum(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;

        int sum = 1 + n;

        for(int i = 2; i <= n/2; i++){
            if(n % i == 0) sum += i;
        }
        return sum;
    }
}

public class Question8{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(my_calculator.divisor_sum(n) + "\n");
    }
}