package Day2.Library;

public class Book {
    private int id;
    private String title;
    private String author;
    private int count;

    //Initialize the attributes
    Book(int id, String title, String author, int count){
        this.id = id;
        this.title = title;
        this.author = author;
        this.count = count;
    }

    //Getter for the title
    public String getTitle(){
        return title;
    }

    //Getter for Id
    public int getId(){
        return id;
    }

    //Getter for Count of the books
    public int getCount(){
        return count;
    }

    //To reduce the count of the book available
    public void reduceCount(){
        this.count -= 1;
    }

    //To increase the count of the boom available
    public void increaseCount(){
        this.count += 1;
    }
}
