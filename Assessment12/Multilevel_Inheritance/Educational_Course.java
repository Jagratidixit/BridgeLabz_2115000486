import java.util.*;

class Course {
    String courseName;
    int duration;
    
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    
    void getCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
    
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    
    @Override
    void getCourseDetails() {
        super.getCourseDetails();
        System.out.println("Platform: " + platform + ", Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;
    
    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    
    @Override
    void getCourseDetails() {
        super.getCourseDetails();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Programming", 6, "Udemy", true, 100, 20);
        course.getCourseDetails();
    }
}
