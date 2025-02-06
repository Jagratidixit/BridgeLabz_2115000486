import java.util.*;

class Doctor {
    String name;
    List<Patient> patients;

    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println(name + " is consulting " + patient.name);
    }

    void showPatients() {
        System.out.println("Doctor: " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
    }
}

class Patient {
    String name;
    List<Doctor> doctors;

    Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    void showDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.name);
        }
    }
}

class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;

    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }

    void showDetails() {
        System.out.println("Hospital: " + name);
        for (Doctor doctor : doctors) {
            doctor.showPatients();
        }
        for (Patient patient : patients) {
            patient.showDoctors();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dubey");
        Doctor d2 = new Doctor("Dixit");

        Patient p1 = new Patient("Aditi");
        Patient p2 = new Patient("Babban");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        hospital.showDetails();
    }
}
