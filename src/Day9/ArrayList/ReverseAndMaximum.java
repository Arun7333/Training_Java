package Day9.ArrayList;

import java.util.*;

public class ReverseAndMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        //Loop for inserting values
        //Loop will end when the value is -1
        int value = scanner.nextInt();
        while(value != -1){
            list.add(value);

            value = scanner.nextInt();
        }

        //Reversing the arrayList
        Collections.reverse(list);

        //Maximum element
        System.out.println("Maximum element is: " + Collections.max(list));

        //displaying the list
        System.out.println(list);
    }
}
