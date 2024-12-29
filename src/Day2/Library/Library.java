package Day2.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Library {

    private Map<Integer, Book> inventory;
    private List<User> users;
    private Librarian librarian;

    //Default constructor
    Library(){
        inventory = new HashMap<>();
        users = new ArrayList<>();
    }

    //Parameterized constructor
    Library(Librarian librarian){
        inventory = new HashMap<>();
        this.librarian = librarian;
        users = new ArrayList<>();
    }

    //Getter for Librarian
    public Librarian getLibrarian(){
        return librarian;
    }

    //Setter for Librarian
    public void setLibrarian(Librarian librarian){
        this.librarian = librarian;
    }

    //To add user in the library
    public void addUser(User user){
        users.add(user);
    }

    //To remove the user from the library
    public void removeUser(User user){
        users.remove(user);
    }

    //To return the books to the librarian
    public List<Book> showBooks(){
        return new ArrayList<>(inventory.values());
    }

    //To add book in the inventory
    public void addBook(Book book){
        inventory.put(book.getId(), book);
    }

    //To remove book in the inventory
    public void removeBook(Book book){
        inventory.remove(book.getId());
    }

    //To check a book is available in the library or not
    public boolean isAvailable(Book book){
        return inventory.get(book.getId()) != null && inventory.get(book.getId()).getCount() > 0;
    }


}
