import java.util.*;

abstract class JobRole {
    String candidateName;
    int experienceYears;

    JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    abstract void displayResume();
}

class SoftwareEngineer extends JobRole {
    String programmingLanguages;

    SoftwareEngineer(String candidateName, int experienceYears, String programmingLanguages) {
        super(candidateName, experienceYears);
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    void displayResume() {
        System.out.println("Software Engineer - Name: " + candidateName + ", Experience: " + experienceYears + " years, Skills: " + programmingLanguages);
    }
}

class DataScientist extends JobRole {
    String tools;

    DataScientist(String candidateName, int experienceYears, String tools) {
        super(candidateName, experienceYears);
        this.tools = tools;
    }

    @Override
    void displayResume() {
        System.out.println("Data Scientist - Name: " + candidateName + ", Experience: " + experienceYears + " years, Tools: " + tools);
    }
}

class ProductManager extends JobRole {
    String domainExpertise;

    ProductManager(String candidateName, int experienceYears, String domainExpertise) {
        super(candidateName, experienceYears);
        this.domainExpertise = domainExpertise;
    }

    @Override
    void displayResume() {
        System.out.println("Product Manager - Name: " + candidateName + ", Experience: " + experienceYears + " years, Expertise: " + domainExpertise);
    }
}

class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public void displayResumes() {
        for (T resume : resumes) {
            resume.displayResume();
        }
    }
}

public class Main {
    public static void displayAllResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.displayResume();
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareResumes = new Resume<>();
        softwareResumes.addResume(new SoftwareEngineer("Jagrati", 5, "Java, Python"));
        softwareResumes.addResume(new SoftwareEngineer("Vishesh", 3, "C++, JavaScript"));

        Resume<DataScientist> dataResumes = new Resume<>();
        dataResumes.addResume(new DataScientist("Prateek", 4, "TensorFlow, Pandas"));
        dataResumes.addResume(new DataScientist("Aditi", 6, "PyTorch, SQL"));

        Resume<ProductManager> pmResumes = new Resume<>();
        pmResumes.addResume(new ProductManager("Somil", 7, "E-Commerce"));
        pmResumes.addResume(new ProductManager("Rashi", 5, "FinTech"));

        System.out.println("Software Engineer Resumes:");
        softwareResumes.displayResumes();

        System.out.println("\nData Scientist Resumes:");
        dataResumes.displayResumes();

        System.out.println("\nProduct Manager Resumes:");
        pmResumes.displayResumes();

        System.out.println("\nDisplaying All Resumes:");
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(new SoftwareEngineer("Manju", 8, "Go, Rust"));
        allResumes.add(new DataScientist("Chris ", 10, "Hadoop, Spark"));
        allResumes.add(new ProductManager("Tony Stark", 9, "HealthTech"));

        displayAllResumes(allResumes);
    }
}
