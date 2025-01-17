package Junit;

public class Factorial {
    public int getFactorial(int num){
        if(num < 0 || num >= 13) return -1;
        if(num == 0) return 1;
        if(num <= 2) return num;
        int result = 1;

        while(num > 0){
            result *= num;
            num--;
        }

        return result;
    }
}
