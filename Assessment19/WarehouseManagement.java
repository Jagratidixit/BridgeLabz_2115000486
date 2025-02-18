import java.util.*;

abstract class WarehouseItem {
    String name;
    int price;
    
    WarehouseItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    abstract void displayInfo();
}

class Electronics extends WarehouseItem {
    String brand;

    Electronics(String name, int price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    void displayInfo() {
        System.out.println("Electronic: " + name + ", Price: " + price + ", Brand: " + brand);
    }
}

class Groceries extends WarehouseItem {
    String expirationDate;

    Groceries(String name, int price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    void displayInfo() {
        System.out.println("Grocerie: " + name + ", Price: " + price + ", Expiration: " + expirationDate);
    }
}

class Furniture extends WarehouseItem {
    String material;

    Furniture(String name, int price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    void displayInfo() {
        System.out.println("Furniture: " + name + ", Price: " + price + ", Material: " + material);
    }
}

// Generic class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void displayparticularTypeInfo() {
        for (T item : items) {
            item.displayInfo();
        }
    }
}

// Wildcard method
public class WarehouseManagement{
    public static void displayItems(List<? extends WarehouseItem> itemlist) {
        for (WarehouseItem item : itemlist) {
            item.displayInfo();
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 1000, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 500, "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apple", 1, "12-12-2025"));
        groceriesStorage.addItem(new Groceries("Banana", 2, "10-10-2025"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 30, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 70, "Metal"));

        System.out.println("Electronics Storage:");
        electronicsStorage.displayparticularTypeInfo();

        System.out.println("\nGroceries Storage:");
        groceriesStorage.displayparticularTypeInfo();

        System.out.println("\nFurniture Storage:");
        furnitureStorage.displayparticularTypeInfo();

        System.out.println("\nDisplaying All Items Using Wildcard:");
        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.add(new Electronics("TV", 400, "Sony"));
        allItems.add(new Groceries("Orange", 3, "15-08-2025"));
        allItems.add(new Furniture("Sofa", 300, "Leather"));

        displayItems(allItems);
    }
}
