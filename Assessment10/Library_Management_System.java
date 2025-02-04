class Book {
    private static String libraryName = "XYZ Library";
    private String title;
    private String author;
    private final int isbn;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Book Title: " + title);
            System.out.println("Book Author: " + author);
            System.out.println("Unique ISBN: " + isbn);
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Palace Of Illusions", "Chitra Banerjee", 1000);
        Book book2 = new Book("Too Good To Be True", "Prajakta Kohli", 1002);
        
        displayLibraryName();
        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}
