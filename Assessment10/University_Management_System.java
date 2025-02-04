import java.util.*;
class Student {
    private static String universityName="GLA University";
    private String studentName;
    private final int rollNumber;
    private double grade;
    private static int totalstudents=0;


    public Student(String studentName,int rollNumber,double grade) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalstudents++;
    }

    public static int displayTotalStudents() {
        return totalstudents;
        
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University name: " + universityName);
            System.out.println("Student name: " + studentName);
            System.out.println("Student RollNumber: " + rollNumber);
            System.out.println("Student Grade: " + grade);
        }
        
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student student1 = new Student("Jagrati Dixit", 2115000486, 9.2);
        Student student2 = new Student("Pranjal Upadhyay", 211500007, 8.5);
    
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        
        System.out.println("Total Students:"+Student.displayTotalStudents());
        
        
    }
}
