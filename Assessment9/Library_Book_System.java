import java.util.*;

public class Book {
    String title;
    String author;
    int price;
    boolean isAvailable;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter book details:");
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();

        Book book = new Book(title, author, price);
        book.display();

        System.out.print("\nDo you want to borrow the book? (yes/no): ");
        String response = sc.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            if (book.borrowBook()) {
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book is already borrowed.");
            }
        }

        book.display();
    }
}
