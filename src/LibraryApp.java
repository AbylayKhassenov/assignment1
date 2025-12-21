import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LibraryApp {

    private List<Book> books = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public void run(){

        boolean play = true;

        while(play) {
            System.out.println("Menu: ");
            System.out.println("All books         (1) ");
            System.out.println("Add book          (2)");
            System.out.println("Search title      (3)");
            System.out.println("Borrow book       (4)");
            System.out.println("Return book       (5)");
            System.out.println("Delete book by id (6)");
            System.out.println("Quit              (7)");

            int menu = scan.nextInt();
            scan.nextLine();

            switch(menu){

                case 1:

                    if(books.isEmpty()){
                        System.out.println("library is empty");
                    }else{
                    System.out.println(books);
                    }

                    break;

                case 2:


                    try {
                        System.out.print("enter title: ");
                        String t = scan.nextLine();

                        System.out.print("enter author: ");
                        String a = scan.nextLine();

                        System.out.print("enter year: ");
                        int y = Integer.parseInt(scan.nextLine());

                        Book book = new Book(t, a, y);
                        books.add(book);

                        System.out.println("book added.");
                        break;

                    } catch (Exception e) {
                        System.out.println("invalid book: " + e.getMessage());
                        break;
                    }

                case 3:

                    System.out.print("enter title: ");
                    String t = scan.nextLine();
                    boolean exist = false;
                    int bnum = books.size();

                    for(int i=0; i<bnum; i++ ){
                        Book search = books.get(i);
                        if (search.getTitle().toLowerCase().contains(t)) {
                            System.out.println("books found: " + search);
                            exist = true;
                        }
                        break;
                    }

                    if(!exist){
                        System.out.println("book not found");
                        break;
                    }

                case 4:
                    System.out.print("enter id: ");
                    int bid = scan.nextInt();


                    boolean ex = false;
                    int num = books.size();

                    for(int i=0; i<num; i++ ){
                        Book search = books.get(i);
                        if (search.getId() == bid && search.isAvailable()) {
                            System.out.println("books " + search.getTitle() + " borrowed");
                            search.markAsBorrowed();
                            ex = true;
                            break;
                        }else if(search.getId() == bid && !search.isAvailable()){
                            System.out.println("books " + search.getTitle() + " is not available");
                            ex = true;
                            break;
                        }

                    }

                    if(!ex){
                        System.out.println("book not found");
                        break;
                    }

                    break;
                case 5:

                    System.out.print("enter id: ");
                    int bookid = scan.nextInt();


                    boolean exists = false;
                    int size = books.size();

                    for(int i=0; i<size; i++ ){
                        Book search = books.get(i);
                        if (search.getId() == bookid && search.isAvailable()) {
                            System.out.println("book " + search.getTitle() + " is not borrowed");
                            exists = true;
                            break;
                        }else if(search.getId() == bookid && !search.isAvailable()){
                            System.out.println("book " + search.getTitle() + "  returned");
                            search.markAsReturned();
                            exists = true;
                            break;
                        }

                    }

                    if(!exists){
                        System.out.println("book not found");
                        break;
                    }

                    break;

                case 6:

                    System.out.print("enter id: ");
                    int delid = scan.nextInt();


                    boolean b_exists = false;
                    int b_size = books.size();

                    for(int i = 0; i< b_size; i++ ){
                        Book search = books.get(i);
                        if (search.getId() == delid) {
                            System.out.println("book " + search.getTitle() + " is deleted");
                            b_exists = true;
                            books.remove(search);
                            break;
                        }
                    }

                    if(!b_exists){
                        System.out.println("book not found");
                        break;
                    }

                    break;
                case 7:
                    play = false;

            }



        }

    }


}
