import java.util.*;

public class Book {
    String title;
    String author;
    double price;

    public Book(String title,String author,double price) {
	this.title=title;
        this.author=author;
	this.price=price;
    }

    public void display() {
        System.out.println("Book title: " + title);
        System.out.println("Book Author: " + author);
	System.out.println("Book price: "+price);
    }

    public static void main(String[] args) {
        Book book1 = new Book("Palace of Illusions","Chitra Banerjee",800);
        book1.display();
    }
}

