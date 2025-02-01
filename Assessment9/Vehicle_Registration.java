import java.util.*;

public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car");
        Vehicle v2 = new Vehicle("Bob", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6000);

        System.out.println("\nAfter updating Registration Fee:\n");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
