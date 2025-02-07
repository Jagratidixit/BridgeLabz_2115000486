import java.util.*;

interface Refuelable {
    void refuel();
}

class Vehicle {
    String model;
    int maxSpeed;
    
    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    
    void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed);
    }
}

class ElectricVehicle extends Vehicle {
    
    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    
    void charge() {
        System.out.println("Charging electric vehicle " + model);
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    
    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    
    public void refuel() {
        System.out.println("Refueling petrol vehicle " + model);
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200);
        PetrolVehicle pv = new PetrolVehicle("Ford Mustang", 250);
        
        ev.displayInfo();
        ev.charge();
        
        pv.displayInfo();
        pv.refuel();
    }
}
