public class Book {

    private int id;
    private static int idGen = 0;
    private String title;
    private String author;
    private int year;
    private boolean available;



    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public Book(){
        this.id = idGen++;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }


    public String getTitle(){
        return title;
    }


    public void setTitle(String title){
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("title value can not be equal to null!");

        }
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }


    public void setAuthor(String author){
        if(author == null || author.isEmpty()){
            throw new IllegalArgumentException("author value can not be equal to null!");

        }
        this.author = author;
    }

    public void setYear(int year){
        if(!(1500<=year && year<=2025)){
            throw new IllegalArgumentException("year value us invalid!");

        }
        this.year = year;
    }

    public int getYear(){
        return year;
    }

    public void markAsBorrowed(){
        this.available = false;

    }



    public void markAsReturned(){
        this.available = true;

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }
}
