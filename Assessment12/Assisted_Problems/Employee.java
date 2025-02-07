import java.util.*;
class Employee {
    String name;
    int id;
    double salary;
    
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    void displayDetails() {
        System.out.println("Employee name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;
    
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;
    
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    int trainingPeriod;
    
    Intern(String name, int id, double salary, int trainingPeriod) {
        super(name, id, salary);
        this.trainingPeriod = trainingPeriod;
    }
    
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Training Period: " + trainingPeriod + " months");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Jagrati", 101, 90000, 5);
        Employee developer = new Developer("Aditi", 102, 70000, "Java");
        Employee intern = new Intern("Vishesh", 103, 30000, 6);
        
        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}
