package Day9.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingList shoppingList = new ShoppingList();
        int n = scanner.nextInt();

        //add items to the list
        for(int i = 0; i < n; i++){
            String item = scanner.next();

            shoppingList.add(item);
        }

        //remove an item from the list
        String item = scanner.next();
        shoppingList.remove(item);

        //display the items in the list
        shoppingList.display();
    }
}

class ShoppingList{
    List<String> list;

    ShoppingList(){
        list = new ArrayList<>();
    }

    public void add(String item){
        list.add(item);
    }

    public void remove(String item){
        list.remove(item);
        System.out.println("Removed");
    }

    public void display(){
        System.out.println("Shopping List:");
        list.stream().forEach(System.out::println);
    }
}