import java.util.*;
class Vehicle {
    String fuelType;
    int maxSpeed;
    
    Vehicle(String fuelType, int maxSpeed) {
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
    }
    
    void displayInfo() {
        System.out.println("Fuel Type of vehicle: " + fuelType);
        System.out.println("Max Speed of vehicle: " + maxSpeed);
    }
}

class Car extends Vehicle {
    int seatCapacity;
    
    Car(String fuelType, int maxSpeed, int seatCapacity) {
        super(fuelType, maxSpeed);
        this.seatCapacity = seatCapacity;
    }
    
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity of car: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int loadCapacity;
    
    Truck(String fuelType, int maxSpeed, int loadCapacity) {
        super(fuelType, maxSpeed);
        this.loadCapacity = loadCapacity;
    }
    
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity of truck: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;
    
    Motorcycle(String fuelType, int maxSpeed, boolean hasSidecar) {
        super(fuelType, maxSpeed);
        this.hasSidecar = hasSidecar;
    }
    
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Petrol", 180, 5),
            new Truck("Diesel", 120, 10),
            new Motorcycle("Petrol", 150, false)
        };
        
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
