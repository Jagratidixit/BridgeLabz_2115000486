import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Project {
    @ImportantMethod
    void coreFunction() {
        System.out.println("Core function executing");
    }

    @ImportantMethod(level = "MEDIUM")
    void helperFunction() {
        System.out.println("Helper function executing");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Method[] methods = Project.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + im.level());
            }
        }
    }
}
