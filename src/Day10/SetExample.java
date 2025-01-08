package Day10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        UniqueNames uniqueNames = new UniqueNames();

        //Adding names
        for(int i = 0; i < n; i++){
            String name = scanner.next();
            uniqueNames.add(name);
        }

        //Check If already present or not
        String name = scanner.next();
        System.out.println("The given name " + name + "contains status : " + uniqueNames.isAvailable(name));

        //Display all the names
        uniqueNames.display();
    }
}

class UniqueNames{
    private Set<String> names;

    UniqueNames(){
        names = new HashSet<>();
    }

    public void add(String name){
        names.add(name);
    }

    public boolean isAvailable(String name){
        return names.contains(name);
    }

    public void display(){
        System.out.println("Unique Names:");
        names.stream().forEach(System.out::println);
    }
}
