import java.util.*;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    Book prev, next;

    Book(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.prev = this.next = null;
    }
}

class LibraryManagement {
    Book head, tail;

    void addBookAtBegin(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    void addBookAtEnd(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    void addBookAtPos(String title, String author, String genre, int bookId, boolean availabilityStatus, int position) {
        if (position <= 1 || head == null) {
            addBookAtBegin(title, author, genre, bookId, availabilityStatus);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, availabilityStatus);
        Book temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newBook.next = temp.next;
        if (temp.next != null) temp.next.prev = newBook;
        temp.next = newBook;
        newBook.prev = temp;
        if (newBook.next == null) tail = newBook;
    }

    void removeBook(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) result.add(temp);
            temp = temp.next;
        }
        return result;
    }

    List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) result.add(temp);
            temp = temp.next;
        }
        return result;
    }

    void updateBookAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.availabilityStatus = newStatus;
                return;
            }
            temp = temp.next;
        }
    }

    void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | Available: " + temp.availabilityStatus);
            temp = temp.next;
        }
    }

    void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | Available: " + temp.availabilityStatus);
            temp = temp.prev;
        }
    }

    int countTotalBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryManagement lm = new LibraryManagement();
        lm.addBookAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        lm.addBookAtBegin("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        lm.addBookAtEnd("1984", "George Orwell", "Dystopian", 103, true);
        lm.addBookAtPos("Moby Dick", "Herman Melville", "Adventure", 104, true, 2);

        System.out.println("Books in forward order:");
        lm.displayBooksForward();

        System.out.println("\nBooks in reverse order:");
        lm.displayBooksReverse();

        lm.updateBookAvailability(101, false);
        System.out.println("\nAfter updating availability:");
        lm.displayBooksForward();

        lm.removeBook(104);
        System.out.println("\nAfter removing 'Moby Dick':");
        lm.displayBooksForward();

        System.out.println("\nTotal books in library: " + lm.countTotalBooks());
    }
}
