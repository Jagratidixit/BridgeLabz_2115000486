import java.util.*;

class Course {
    String name;
    List<Student> students;

    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void enrollStudent(Student student) {
        students.add(student);
        student.enrollInCourse(this);
    }

    void showEnrolledStudents() {
        System.out.println("Course: " + name);
        for (Student student : students) {
            System.out.println("Student: " + student.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses;

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    void showEnrolledCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("Enrolled in: " + course.name);
        }
    }
}

class School {
    String name;
    List<Student> students;

    School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void showStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("Student: " + student.name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Mercy Memorial");

        Student s1 = new Student("Jagrati");
        Student s2 = new Student("Aditi");

        school.addStudent(s1);
        school.addStudent(s2);

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s1);

        school.showStudents();
        s1.showEnrolledCourses();
        s2.showEnrolledCourses();
        c1.showEnrolledStudents();
        c2.showEnrolledStudents();
    }
}
