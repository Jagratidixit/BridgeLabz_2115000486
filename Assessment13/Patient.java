abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;

    public InPatient(int patientId, String name, int age, double roomCharge) {
        super(patientId, name, age);
        this.roomCharge = roomCharge;
    }

    public double calculateBill() {
        return roomCharge * 5;
    }

    public void addRecord(String record) {
        System.out.println("Medical Record Added: " + record);
    }

    public void viewRecords() {
        System.out.println("Viewing Medical Records.");
    }
}

class HospitalManagement {
    public static void main(String[] args) {
        Patient patient = new InPatient(401, "John Doe", 45, 2000);
        patient.getPatientDetails();
        System.out.println("Total Bill: " + patient.calculateBill());
    }
}
