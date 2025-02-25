import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Task {
    @LogExecutionTime
    void execute() {
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++);
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) + " ns");
    }
}

public class Main {
    public static void main(String[] args) {
        new Task().execute();
    }
}
