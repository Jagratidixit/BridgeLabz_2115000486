abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return getPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "5% discount on Veg Items";
    }
}

class FoodDelivery {
    public static void main(String[] args) {
        FoodItem vegBurger = new VegItem("Veg Burger", 100, 2);
        vegBurger.getItemDetails();
        System.out.println("Total Price: " + vegBurger.calculateTotalPrice());
    }
}
