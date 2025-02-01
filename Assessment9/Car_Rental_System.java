import java.util.*;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    int costPerDay = 500; //  cost per day

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public int calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter car rental details:");
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter Car Model: ");
        String carModel = sc.nextLine();
        System.out.print("Enter Rental Days: ");
        int rentalDays = sc.nextInt();

        CarRental car = new CarRental(customerName, carModel, rentalDays);
        car.display();
    }
}
