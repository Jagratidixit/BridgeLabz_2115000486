class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class PostgraduateStudent extends Student {
    public String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateDetails() {
        displayStudentDetails();
        System.out.println("Specialization: " + specialization);
    }
}

public class Main {
    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "Rahul", 8.5, "Artificial Intelligence");
        pgStudent.displayPostgraduateDetails();

        pgStudent.setCGPA(9.0);
        System.out.println("\nAfter Updating CGPA:");
        pgStudent.displayPostgraduateDetails();
    }
}
