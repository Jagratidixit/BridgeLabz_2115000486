import java.util.*;
public class Book{
    String title;
    String author;
    
    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }
    
    void display(){
        System.out.println("Book "+title+" by "+author);
    }
}
public class Library{
    String name;
    List<Book> books;
    
    public Library(String name){
        this.name=name;
        this.books=new ArrayList<>();
    }
    
    void addbook(Book book){
        books.add(book);
    }
    
    void showbooks(){
        System.out.println("Library :"+ name);
        for(Book book:books){
            book.display();
        }
    }
    
}

public class Main{
    public static void main(String[] args){
        Library library1=new Library("City Library");
        Library library2=new Library("University Library");
        
        Book book1=new Book("Alchemist","Paulo Coelho");
        Book book2=new Book("Norwegian Wood","Haruki Murakami");
        Book book3=new Book("Palace Of Illusions","Chitra Banerjee");
        
        library1.addbook(book1);
        library2.addbook(book2);
        
        library1.addbook(book3);
        library2.addbook(book1);
        
        library1.showbooks();
        library2.showbooks();
        
    }
}
