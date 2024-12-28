package Day2.Library;

import java.util.ArrayList;
import java.util.List;

abstract class User {

    private int id;
    private String name;
    private String email;
    private String role;
    private final Librarian librarian;
    private List<Book> borrowedBooks;

    //To Initialize the attributes
    User(int id, String name, String email, String role, Librarian librarian){
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.librarian = librarian;
        borrowedBooks = new ArrayList<>();
    }

    //To borrow books from the library
    public void borrowBook(Book book){
        try{
            librarian.issueBook(this, book);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        borrowedBooks.add(book);
    }

    //To return the borrowed books
    public void returnBook(Book book){
        librarian.returnBook(this, book);
        borrowedBooks.remove(book);
    }

    //To get the first book from the borrowed books list
    public Book getFirstBorrowedBook() throws noBooksBorrowed{
        if(!borrowedBooks.isEmpty()){
            return borrowedBooks.get(0);
        }
        else throw new noBooksBorrowed();
    }

    //Return the role of the user
    public String getRole(){
        return role;
    }

    //Get the list of the books available in the library
    public List<Book> getListOfBooks(){
        return librarian.showBooks();
    }

    //show the borrowed books of the user
    public void showBorrowedBooks(){

        System.out.println("Borrowed books are:");
        for(Book book : borrowedBooks){
            System.out.println(book.getTitle());
        }
    }
}


class Student extends User{

    Student(int id, String name, String email, Librarian librarian){
        super(id, name, email, "Student", librarian);
    }
}


class Faculty extends User{

    Faculty(int id, String name, String email, Librarian librarian){
        super(id, name, email, "Faculty", librarian);
    }
}
