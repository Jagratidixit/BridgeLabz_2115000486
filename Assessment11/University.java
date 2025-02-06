import java.util.*;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String name;
    List<Faculty> facultyMembers;

    Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    void showFaculty() {
        System.out.println("Department: " + name);
        for (Faculty faculty : facultyMembers) {
            faculty.display();
        }
    }
}

class University {
    String name;
    List<Department> departments;

    University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    void addFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.name.equals(deptName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found.");
    }

    void showDetails() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            dept.showFaculty();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        University uni = new University("GLA University");

        uni.addDepartment("Computer Science");
        uni.addDepartment("Physics");

        Faculty f1 = new Faculty("XYZ");
        Faculty f2 = new Faculty("ABC");

        uni.addFacultyToDepartment("Computer Science", f1);
        uni.addFacultyToDepartment("Physics", f2);

        uni.showDetails();
    }
}
