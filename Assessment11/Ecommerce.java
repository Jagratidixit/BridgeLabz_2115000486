import java.util.*;
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Product: " + name + " | Price: $" + price);
    }
}

class Order {
    int orderId;
    Customer customer;
    List<Product> products;

    Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.name);
        for (Product p : products) {
            p.display();
        }
    }
}

class Customer {
    String name;
    List<Order> orders;

    Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    void placeOrder(Order order) {
        orders.add(order);
    }

    void showOrders() {
        System.out.println("Customer: " + name + " has placed the following orders:");
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Jagrati");

        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Phone", 800);
        Product p3 = new Product("Headphones", 150);

        Order o1 = new Order(101, c1);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = new Order(102, c1);
        o2.addProduct(p3);

        c1.placeOrder(o1);
        c1.placeOrder(o2);

        c1.showOrders();
    }
}
