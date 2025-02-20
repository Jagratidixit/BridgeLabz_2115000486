import java.util.*;

class ShoppingCart {
    Map<String, Double> productPrices = new HashMap<>();
    Map<String, Double> orderedCart = new LinkedHashMap<>();
    TreeMap<Double, String> sortedCart = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        orderedCart.put(product, price);
        sortedCart.put(price, product);
    }

    public void displayCart() {
        System.out.println("Product Prices (Unordered): " + productPrices);
        System.out.println("Ordered Cart (Insertion Order): " + orderedCart);
        System.out.println("Sorted Cart (Price Order): " + sortedCart);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 800.0);
        cart.addProduct("Phone", 500.0);
        cart.addProduct("Headphones", 100.0);

        cart.displayCart();
    }
}
