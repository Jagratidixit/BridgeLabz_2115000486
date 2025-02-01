import java.util.*;

public class Book {
    String title;
    String author;
    double price;

    public Book() {}

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Book title: " + title);
        System.out.println("Book author: " + author);
        System.out.println("Book price: " + price);
    }

    public static void main(String[] args) {
        Book b1 = new Book("The Forest Of Illusions", "Chitra Banerjee", 900);
        b1.display();
    }
}
