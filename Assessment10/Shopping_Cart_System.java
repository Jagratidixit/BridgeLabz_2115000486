import java.util.*;
class Product {
    private static double discount;
    private String productName;
    private int price;
    private int quantity;
    private final int productID;
    

    public Product(String productName, int price, int quantity,int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID=productID;
    }

    public static void updateDiscount(double newdiscount) {
        discount=newdiscount;
        
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product name: " + productName);
            System.out.println("Product price: " + price);
            System.out.println("Product Quantity: " + quantity);
            System.out.println("Product ID: " + productID);
            System.out.println("Discount: " + discount + "%");
        }
        
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Product product1 = new Product("Dyson", 56000, 15,1000);
        Product product2 = new Product("Iphone 15 pro", 80000, 7,1001);
        System.out.print("Enter the new discount percentage :");
        double newdiscount=sc.nextDouble();
        
        updateDiscount(newdiscount);
        
        product1.displayProductDetails();
        product2.displayProductDetails();
        
        
    }
}
