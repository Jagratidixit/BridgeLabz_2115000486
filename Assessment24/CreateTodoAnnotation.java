import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class DevWork {
    @Todo(task = "Implement login", assignedTo = "Alice", priority = "HIGH")
    void loginFeature() {}

    @Todo(task = "Optimize database", assignedTo = "Bob")
    void optimizeDB() {}
}

public class Main {
    public static void main(String[] args) throws Exception {
        Method[] methods = DevWork.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task() + ", Assigned To: " + todo.assignedTo() + ", Priority: " + todo.priority());
            }
        }
    }
}
