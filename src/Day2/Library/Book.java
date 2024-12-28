package Day2.Library;

class Book {
    private int id;
    public String title;
    public String author;
    private int count;

    Book(int id, String title, String author, int count){
        this.id = id;
        this.title = title;
        this.author = author;
        this.count = count;
    }

    public String getTitle(){
        return title;
    }

    public int getId(){
        return id;
    }

    public int getCount(){
        return count;
    }

    public void reduceCount(){
        this.count -= 1;
    }

    public void increaseCount(){
        this.count += 1;
    }
}
