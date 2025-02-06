import java.util.*;

class Course {
    String name;
    Professor professor;
    List<Student> students;

    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this);
    }

    void enrollStudent(Student student) {
        students.add(student);
        student.addCourse(this);
    }

    void showDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Taught by: " + professor.name);
        }
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
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

    void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    void showEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

class Professor {
    String name;
    List<Course> courses;

    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    void showCourses() {
        System.out.println("Professor: " + name + " teaches:");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Kajal");
        Student s2 = new Student("JagratiLi");

        Professor p1 = new Professor("Dr.Malhotra");
        Professor p2 = new Professor("Prof.Dubey");

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s1);

        s1.showEnrolledCourses();
        s2.showEnrolledCourses();
        p1.showCourses();
        p2.showCourses();
        c1.showDetails();
        c2.showDetails();
    }
}
