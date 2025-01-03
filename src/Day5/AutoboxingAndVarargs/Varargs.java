package Day5.AutoboxingAndVarargs;

public class Varargs {

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3, 4, 5, 6, 7, 8));
    }

    //variable number of arguments can be given of the same type
    public static int add(int... nums){
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        return sum;
    }
}
