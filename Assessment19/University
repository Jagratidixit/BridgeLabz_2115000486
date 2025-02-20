import java.util.*;

abstract class CourseType {
    String courseName;
    int price;
    
    CourseType(String courseName, int price) {
        this.courseName = courseName;
        this.price = price;
    }
    
    abstract void displayInfo();
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName, int price) {
        super(courseName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("Exam Course: " + courseName + ", Price: " + price);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName, int price) {
        super(courseName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("Assignment Course: " + courseName + ", Price: " + price);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName, int price) {
        super(courseName, price);
    }

    @Override
    void displayInfo() {
        System.out.println("Research Course: " + courseName + ", Price: " + price);
    }
}

// Generic class to manage courses
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public void displayParticularCourseInfo() {
        for (T course : courses) {
            course.displayInfo();
        }
    }

    public void findCoursesInRange(int minPrice, int maxPrice) {
        System.out.println("\nCourses in price range " + minPrice + " - " + maxPrice + ":");
        for (T course : courses) {
            if (course.price >= minPrice && course.price <= maxPrice) {
                course.displayInfo();
            }
        }
    }
}

// Wildcard method to display mixed course types
public class University {
    public static void displayAllCourses(List<? extends CourseType> courseList) {
        for (CourseType course : courseList) {
            course.displayInfo();
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Math Final", 1000));
        examCourses.addCourse(new ExamCourse("Physics Final", 1200));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Software Project", 1500));
        assignmentCourses.addCourse(new AssignmentCourse("Data Structures", 1300));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research", 2000));
        researchCourses.addCourse(new ResearchCourse("Quantum Computing", 2500));

        System.out.println("Exam Courses:");
        examCourses.displayParticularCourseInfo();

        System.out.println("\nAssignment Courses:");
        assignmentCourses.displayParticularCourseInfo();

        System.out.println("\nResearch Courses:");
        researchCourses.displayParticularCourseInfo();

        // Using new function: Find courses within a price range
        examCourses.findCoursesInRange(900, 1100);
        assignmentCourses.findCoursesInRange(1200, 1600);
        researchCourses.findCoursesInRange(1800, 2600);

        System.out.println("\nDisplaying All Courses Using Wildcard:");
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse("Biology Final", 1100));
        allCourses.add(new AssignmentCourse("Machine Learning Assignment", 1400));
        allCourses.add(new ResearchCourse("Cybersecurity Research", 2300));

        displayAllCourses(allCourses);
    }
}
