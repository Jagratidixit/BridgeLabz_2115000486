import java.util.Scanner;

public class total_price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the unit price of the item : ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter the quantity to be bought: ");
        int quantity = sc.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.printf("The total purchase price is %.2f if the quantity is %d and unit price is %.2f%n", totalPrice, quantity, unitPrice);
    }
}
