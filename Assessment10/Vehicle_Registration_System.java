class Vehicle {
    private static double registrationFee = 5000.0;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Jagrati Dixit", "Car", "UP78EN5600");
        Vehicle vehicle2 = new Vehicle("Aditi Dixit", "Motorcycle", "UP77ER5600");
        
        updateRegistrationFee(5500.0);
        
        vehicle1.displayRegistrationDetails();
        vehicle2.displayRegistrationDetails();
    }
}
