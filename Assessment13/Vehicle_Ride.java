  GNU nano 8.2                   Vehicle_Ride.java



abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public int getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("ID: " + vehicleId + ", Driver: " + driverName + ", Rate/Km: " + ratePerKm);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends Vehicle implements GPS {
    public Car(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return "Current location retrieved";
    }

    public void updateLocation(String location) {
        System.out.println("Location updated to: " + location);
    }
}

class RideHailing {
    public static void main(String[] args) {
        Vehicle car = new Car(501, "Alice", 15);
        car.getVehicleDetails();
        System.out.println("Fare: " + car.calculateFare(10));
    }
}
