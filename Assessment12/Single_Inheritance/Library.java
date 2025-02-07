import java.util.*;

class Book {
    String title;
    int publicationYear;
    
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;
    
    Author(String name, String bio, String title, int publicationYear) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

public class Main {
    public static void main(String[] args) {
        Author author = new Author("J.K. Rowling", "British author, best known for the Harry Potter series", "Harry Potter and the Sorcerer's Stone", 1997);
        author.displayInfo();
    }
}
