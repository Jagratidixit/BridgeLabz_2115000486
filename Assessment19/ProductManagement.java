import java.util.*;

abstract class ProductCatalog {
    String name;
    int price;
    String category;
    
    ProductCatalog(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    abstract void displayInfo();
}

class Book extends ProductCatalog {
    String author;

    Book(String name, int price, String category, String author) {
        super(name, price, category);
        this.author = author;
    }

    @Override
    void displayInfo() {
        System.out.println("Book: " + name + ", Price: " + price + ", Category: " + category + ", Author: " + author);
    }
}

class Clothing extends ProductCatalog {
    String brand;

    Clothing(String name, int price, String category, String brand) {
        super(name, price, category);
        this.brand = brand;
    }

    @Override
    void displayInfo() {
        System.out.println("Clothing: " + name + ", Price: " + price + ", Category: " + category + ", Brand: " + brand);
    }
}

class Gadgets extends ProductCatalog {
    String batteryLife;

    Gadgets(String name, int price, String category, String batteryLife) {
        super(name, price, category);
        this.batteryLife = batteryLife;
    }

    @Override
    void displayInfo() {
        System.out.println("Gadget: " + name + ", Price: " + price + ", Category: " + category + ", Battery Life: " + batteryLife);
    }
}

// Generic class to manage products
class Product<T extends ProductCatalog> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void displayparticularProductInfo() {
        for (T item : items) {
            item.displayInfo();
        }
    }

    public void applyDiscount(T product, double percentage) {
        double discountAmount = product.price * (percentage / 100);
        product.price -= (int) discountAmount; // Convert to int for consistency
        System.out.println("Discount applied! New price of " + product.name + " is: " + product.price);
    }
}

// Wildcard method to display mixed product types
public class ProductManagement {
    public static void displayItems(List<? extends ProductCatalog> productlist) {
        for (ProductCatalog item : productlist) {
            item.displayInfo();
        }
    }

    public static void main(String[] args) {
        Product<Book> bookCatalog = new Product<>();
        bookCatalog.addItem(new Book("Harry Potter", 500, "Fantasy", "J.K. Rowling"));
        bookCatalog.addItem(new Book("The Alchemist", 400, "Fiction", "Paulo Coelho"));

        Product<Clothing> clothingCatalog = new Product<>();
        clothingCatalog.addItem(new Clothing("T-Shirt", 800, "Casual", "Nike"));
        clothingCatalog.addItem(new Clothing("Jeans", 1200, "Denim", "Levi's"));

        Product<Gadgets> gadgetCatalog = new Product<>();
        gadgetCatalog.addItem(new Gadgets("Smartphone", 20000, "Electronics", "10 hours"));
        gadgetCatalog.addItem(new Gadgets("Laptop", 50000, "Computing", "8 hours"));

        System.out.println("Books Catalog:");
        bookCatalog.displayparticularProductInfo();

        System.out.println("\nClothing Catalog:");
        clothingCatalog.displayparticularProductInfo();

        System.out.println("\nGadget Catalog:");
        gadgetCatalog.displayparticularProductInfo();

        System.out.println("\nApplying Discounts:");
        bookCatalog.applyDiscount(new Book("The Alchemist", 400, "Fiction", "Paulo Coelho"), 10);
        clothingCatalog.applyDiscount(new Clothing("Jeans", 1200, "Denim", "Levi's"), 15);
        gadgetCatalog.applyDiscount(new Gadgets("Smartphone", 20000, "Electronics", "10 hours"), 5);

        System.out.println("\nDisplaying All Items Using Wildcard:");
        List<ProductCatalog> allItems = new ArrayList<>();
        allItems.add(new Book("The Hobbit", 600, "Fantasy", "J.R.R. Tolkien"));
        allItems.add(new Clothing("Jacket", 2500, "Winter Wear", "Adidas"));
        allItems.add(new Gadgets("Tablet", 30000, "Electronics", "12 hours"));

        displayItems(allItems);
    }
}
