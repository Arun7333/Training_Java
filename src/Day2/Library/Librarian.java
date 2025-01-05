package Day2.Library;

import java.util.List;

public class Librarian {

    private int id;
    public String name;
    private Library library;

    //Initialize the attributes
    public Librarian(int id, String name, Library library){
        this.id = id;
        this.name = name;
        this.library = library;
    }


    //To add the books in the library
    public void addBook(Book book){
        library.addBook(book);
        System.out.println(book.getTitle() + " is added to the library.");
    }


    //To remove the book from the library
    public void removeBook(Book book){
        library.removeBook(book);
        System.out.println(book.getTitle() + " is removed from the library.");
    }

    //To add the user to the library
    public void addUser(User user){
        library.addUser(user);
    }

    //To remove the user from the library
    public void removeUser(User user){
        library.removeUser(user);
    }


    //To issue book to the user
    public void issueBook (User user, Book book) throws bookNotAvailable{

        if(library.isAvailable(book)){
            book.reduceCount();
        }
        else throw new bookNotAvailable();
    }


    //To return the book from the user
    public void returnBook(User user, Book book){
        book.increaseCount();
    }

    //To get the books from the library to the user
    public List<Book> showBooks(){
        return library.showBooks();
    }
}
