package Day2.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Library {
    private Map<Integer, Book> inventory;
    private List<User> users;
    private Librarian librarian;

    Library(){
        inventory = new HashMap<>();
        users = new ArrayList<>();
    }

    Library(Librarian librarian){
        inventory = new HashMap<>();
        this.librarian = librarian;
        users = new ArrayList<>();
    }

    public Librarian getLibrarian(){
        return librarian;
    }

    public void setLibrarian(Librarian librarian){
        this.librarian = librarian;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

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
        return inventory.get(book.getId()).getCount() > 0;
    }


}
