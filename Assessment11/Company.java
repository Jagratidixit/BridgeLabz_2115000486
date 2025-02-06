import java.util.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    String name;
    List<Employee> employees;

    Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.display();
        }
    }
}

class Company {
    String name;
    List<Department> departments;

    Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (dept.name.equals(deptName)) {
                dept.addEmployee(empName);
                return;
            }
        }
        System.out.println("Department not found.");
    }

    void showDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showEmployees();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("IT", "Jagrati");
        company.addEmployeeToDepartment("IT", "Aditi");
        company.addEmployeeToDepartment("HR", "Vishesh");

        company.showDetails();
    }
}
