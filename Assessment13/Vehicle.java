abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return days * 1000;
    }

    public double calculateInsurance() {
        return 5000;
    }

    public String getInsuranceDetails() {
        return "Insurance Cost: 5000";
    }
}

class VehicleRental {
    public static void main(String[] args) {
        Vehicle car = new Car("1234", 1000);
        System.out.println("Rental Cost: " + car.calculateRentalCost(5));
        System.out.println(((Insurable) car).getInsuranceDetails());
    }
}
