import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJson {
    public static void main(String[] args) throws Exception {
        List<Student> students = Arrays.asList(new Student("Rahul", 22), new Student("Amit", 24));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(students);
        System.out.println(json);
    }
}
