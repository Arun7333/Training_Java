package Day5.AutoboxingAndVarargs;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) list.add(i);

        System.out.println(sum(list));
    }

    public static int sum(List<Integer> list){
        int sum = 0;

        for(int num : list){//Here the Autoboxing takes place
            sum += num;
        }

        return sum;
    }
}
