package Day9.hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ContactManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactDirectory contacts = new ContactDirectory();
        int n = scanner.nextInt();

        //add contacts to the directory
        for(int i = 0; i < n; i++){
            String name = scanner.next();
            long phoneNumber = scanner.nextLong();

            contacts.add(name, phoneNumber);
        }

        //search for a particular contact in the directory
        String key = scanner.next();
        contacts.search(key);

        //remove a contact from the directory
        String name = scanner.next();
        contacts.remove(name);

        //display the contacts in the directory
        contacts.display();
    }
}

class ContactDirectory{
    private Map<String, Long> directory;

    ContactDirectory(){
        directory = new HashMap<>();
    }

    public void add(String name, long phoneNumber){
        directory.put(name, phoneNumber);
    }

    public void remove(String name){
        directory.remove(name);
    }

    public void search(String name){
        System.out.println(directory.get(name));
    }

    public void display(){
        System.out.println("Contact Directory: ");
        for(String name : directory.keySet()){
            System.out.println(name + " : " + directory.get(name));
        }
    }
}
