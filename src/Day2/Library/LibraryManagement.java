package Day2.Library;

import java.util.List;

public class LibraryManagement {
    public static void main(String[] args) {

        //Initializing objects
        Library library = new Library();
        Librarian librarian = new Librarian(01, "Muthu", library);

        library.setLibrarian(librarian);

        //creating user
        User user1 = new Student(01, "Arun", "aarunkarthik3@gmail.com", librarian);
        User user2 = new Faculty(02, "Karthi", "karthik3@gmail.com", librarian);

        //Adding user to the library
        librarian.addUser(user1);
        librarian.addUser(user2);

        //Creating the books
        Book book1 = new Book(01, "Persuit of happiness", "Shakespere", 3);
        Book book2 = new Book(02, "Golden Habits", "Arun", 3);
        Book book3 = new Book(03, "How to be Productive", "Arun", 3);

        //Adding books to the library through librarian
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);

        //Getting the list of books from the library as an user
        List<Book> books = user1.getListOfBooks();

        //borrowing books
        for(int i = 0; i < books.size()/2; i ++){
            user1.borrowBook(books.get(i));
        }


        for(int i = books.size()/2; i < books.size(); i++){
            user2.borrowBook(books.get(i));
        }

        System.out.println("Before Returning:");
        user1.showBorrowedBooks();
        user2.showBorrowedBooks();

        //return the books
        try {
            user1.returnBook(user1.getFirstBorrowedBook());
            user2.returnBook(user2.getFirstBorrowedBook());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("After returning:");
        user1.showBorrowedBooks();
        user2.showBorrowedBooks();
    }
}
